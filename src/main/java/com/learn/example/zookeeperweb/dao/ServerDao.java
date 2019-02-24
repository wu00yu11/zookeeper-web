package com.learn.example.zookeeperweb.dao;

import com.learn.example.zookeeperweb.model.Server;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerDao {
    void add(Server server);

    void update(Server server);

    Server query(Server server);

    List<Server> queryAll();
}
