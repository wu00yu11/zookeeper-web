package com.learn.example.zookeeperweb.service;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author zjj
 * @date 2019/2/22 0022
 */
@Service
public class ZookeeperServiceImpl implements ZookeeperService {

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperServiceImpl.class);
    @Autowired
    private CuratorFramework curatorFramework;


    @Override
    public void add(String path, CreateMode createMode, String data) {
        try {
            curatorFramework.create().withMode(createMode).forPath(path, data.getBytes());
        } catch (Exception e) {
            logger.error("创建节点失败, elog=" + e.getMessage());
        }
    }

    @Override
    public void update(String path,  String data) {
        try {
            curatorFramework.setData().forPath(path,data.getBytes());
        } catch (Exception e) {
            logger.error("更新节点失败, elog=" + e.getMessage());
        }
    }

    @Override
    public void delete(String path) {
        try {
            curatorFramework.delete().forPath(path);
        } catch (Exception e) {
            logger.error("删除节点失败, elog=" + e.getMessage());
        }
    }

    @Override
    public void query(String path) {
        try {
            curatorFramework.getData().forPath(path);
        } catch (Exception e) {
            logger.error("获取数据失败, elog=" + e.getMessage());
        }
    }

    @Override
    public void nodeList(String path) {
        List<String> paths = null;
        try {
            paths = curatorFramework.getChildren().forPath(path);
        } catch (Exception e) {
            logger.error("获取节点列表失败, elog=" + e.getMessage());
            return;
        }
        for (String data : paths) {
            logger.info("获取节点列表=" + data);
        }
    }
}
