package com.learn.example.zookeeperweb.controller;

import com.learn.example.zookeeperweb.service.ZookeeperService;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zjj
 * @date 2019/2/22 0022
 */
@Controller
@RequestMapping(value = "/zk")
public class ZookeeperController {
    private static final Logger logger = LoggerFactory.getLogger(ZookeeperController.class);

    @Autowired
    private ZookeeperService zookeeperService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    String add(String path, String data){
        zookeeperService.add(path, CreateMode.PERSISTENT_SEQUENTIAL,data);
        return "index";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    String update(String path, String data){
        zookeeperService.update(path, data);
        return "index";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    String delete(String path){
        zookeeperService.delete(path);
        return "index";
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    String query(String path){
        zookeeperService.query(path);
        return "index";
    }

    @RequestMapping(value = "/nodeList",method = RequestMethod.GET)
    String nodeList(String path){
        zookeeperService.nodeList(path);
        return "index";
    }
    @RequestMapping(value = "/nodeList",method = RequestMethod.GET)
    String monitor(){
        zookeeperService.monitor();
        return  "index";
    }


}
