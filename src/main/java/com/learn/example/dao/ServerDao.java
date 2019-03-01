package com.learn.example.dao;

import com.learn.example.model.Server;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerDao {
    void add(Server server);

    void update(Server server);

    Server query(Server server);

    List<Server> queryAll();
}
