package com.learn.example.zookeeperweb.service;

import com.learn.example.zookeeperweb.exception.BizException;

import java.util.List;

/**
 * @author zjj
 * @date 2019/2/22 0022
 */
public interface ZookeeperService {

    void add(String host, String path, String mode, String data) throws BizException;

    void update(String host, String path, String data) throws BizException;

    void delete(String host, String path) throws BizException;

    String queryData(String host, String path) throws BizException;

    List<String> nodeList(String host, String path) throws BizException;

    String monitor() throws BizException;
}
