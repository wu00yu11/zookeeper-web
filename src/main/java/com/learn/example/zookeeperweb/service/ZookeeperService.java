package com.learn.example.zookeeperweb.service;

import org.apache.zookeeper.CreateMode;

/**
 *
 * @author zjj
 * @date 2019/2/22 0022
 */
public interface ZookeeperService {

    void add(String path, CreateMode createMode, String data);

    void update(String path, String data);

    void delete(String path);

    void query(String path);

    void nodeList(String path);

    String monitor();
}
