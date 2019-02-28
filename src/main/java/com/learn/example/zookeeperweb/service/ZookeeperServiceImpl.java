package com.learn.example.zookeeperweb.service;

import com.learn.example.zookeeperweb.exception.BizException;
import com.learn.example.zookeeperweb.util.CmdUtil;
import com.learn.example.zookeeperweb.util.CuratorClientCache;
import com.learn.example.zookeeperweb.util.ModeUtil;
import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author zjj
 * @date 2019/2/22 0022
 */
@Service
public class ZookeeperServiceImpl implements ZookeeperService {

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperServiceImpl.class);


    @Override
    public void add(String host, String path, String createMode, String data) throws BizException {
        try {
            CuratorClientCache.INSTANCE.getClient(host).create().creatingParentsIfNeeded().withMode(ModeUtil.CREATE_MODE(createMode)).forPath(path, data.getBytes());
        } catch (KeeperException.NodeExistsException kn) {
            logger.error(path + "节点已经存在, elog=", kn);
            throw new BizException(path + "节点已经存在", kn.getCause());
        } catch (Exception e) {
            logger.error("创建节点失败, elog=", e);
            throw new BizException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void update(String host, String path, String data) throws BizException {
        try {
            CuratorClientCache.INSTANCE.getClient(host).setData().forPath(path, data.getBytes());
        } catch (Exception e) {
            logger.error("更新节点失败, elog=", e);
            throw new BizException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void delete(String host, String path) throws BizException {
        try {
            CuratorClientCache.INSTANCE.getClient(host).delete().forPath(path);
        } catch (Exception e) {
            logger.error("删除节点失败, elog=", e);
            throw new BizException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public String queryData(String host, String path) throws BizException {
        try {
            return new String(CuratorClientCache.INSTANCE.getClient(host).getData().forPath(path));
        } catch (Exception e) {
            logger.error("获取数据失败, elog=", e);
            throw new BizException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<String> nodeList(String host, String path) throws BizException {
        List<String> paths = null;
        try {
            paths = CuratorClientCache.INSTANCE.getClient(host).getChildren().forPath(path);
        } catch (Exception e) {
            logger.error("获取节点列表失败, elog=" + e.getMessage());
            throw new BizException(e.getMessage(), e.getCause());
        }
        return paths;
    }

    @Override
    public String monitor() throws BizException {
        try {
            CmdUtil.INSTANCE.executeCmd("", "", "");
        } catch (IOException e) {
            logger.error("获取服务状态信息失败, elog=" + e.getMessage());
            throw new BizException(e.getMessage(), e.getCause());

        }
        return null;
    }
}
