package com.learn.example.zookeeperweb.service;

import com.learn.example.zookeeperweb.model.Server;

import java.util.List;

/**
 * 服务操作
 */
public interface ServerService {

    void add(Server server);

    void update(Server server);

    Server query(Server server);

    List<Server> queryAll();

}
