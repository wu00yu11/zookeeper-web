package com.learn.example.zookeeperweb.service;

import com.learn.example.zookeeperweb.dao.ZkCfgDao;
import com.learn.example.zookeeperweb.model.ZkCfg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zjj
 * @date 2019/2/28 0028
 */
@Service
public class ZkCfgServiceImpl implements ZkCfgService {

    private static final Logger logger = LoggerFactory.getLogger(ZkCfgServiceImpl.class);

    @Resource
    private ZkCfgDao zkCfgDao;

    @Override
    public void add(ZkCfg zkCfg) {
        zkCfgDao.add(zkCfg);
    }

    @Override
    public void update(ZkCfg zkCfg) {
        zkCfgDao.update(zkCfg);
    }

    @Override
    public void delete(ZkCfg zkCfg) {
        zkCfgDao.delete(zkCfg);
    }

    @Override
    public List<ZkCfg> query(ZkCfg zkCfg) {
        return zkCfgDao.query(zkCfg);
    }
}
