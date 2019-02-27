package com.learn.example.zookeeperweb.dao;

import org.springframework.stereotype.Repository;

/**
 *
 * @author zjj
 * @date 2019/2/25 0025
 */
@Repository
public interface ZkCfgDao {

    void add();

    void update();

    void query();

    void delete();

}
