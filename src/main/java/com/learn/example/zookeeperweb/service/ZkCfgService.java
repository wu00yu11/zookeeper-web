package com.learn.example.zookeeperweb.service;

import com.learn.example.zookeeperweb.model.ZkCfg;

import java.util.List;

/**
 * @author zjj
 * @date 2019/2/28 0028
 */
public interface ZkCfgService {

    void add(ZkCfg zkCfg);

    void update(ZkCfg zkCfg);

    void delete(ZkCfg zkCfg);

    List<ZkCfg> query(ZkCfg zkCfg);
}
