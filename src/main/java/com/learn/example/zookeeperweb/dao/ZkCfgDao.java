package com.learn.example.zookeeperweb.dao;

import com.learn.example.zookeeperweb.model.ZkCfg;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjj
 * @date 2019/2/25 0025
 */
@Repository
public interface ZkCfgDao {

    void add(ZkCfg zkCfg);

    void update(ZkCfg zkCfg);

    void delete(ZkCfg zkCfg);

    List<ZkCfg> query(ZkCfg zkCfg);

}
