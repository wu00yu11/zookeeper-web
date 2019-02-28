package com.learn.example.zookeeperweb.controller;

import com.learn.example.zookeeperweb.model.ZkCfg;
import com.learn.example.zookeeperweb.service.ZkCfgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * zookeeper配置项管理
 * @author zjj
 * @date 2019/2/28 0028
 */
@Controller
@RequestMapping(value = "/zkCfg")
public class ZkCfgController {

    private static final Logger logger = LoggerFactory.getLogger(ZkCfgController.class);

    @Resource
    private ZkCfgService zkCfgService;

    @GetMapping("/add")
    public String add(ZkCfg zkCfg){
        zkCfgService.add(zkCfg);
        return "index";
    }
    @GetMapping("/update")
    public String update(ZkCfg zkCfg){
        zkCfgService.update(zkCfg);
        return "index";
    }
    @GetMapping("/delete")
    public String delete(ZkCfg zkCfg){
        zkCfgService.delete(zkCfg);
        return "index";
    }
    @GetMapping("/query")
    public String query(ZkCfg zkCfg){
        zkCfgService.query(zkCfg);
        return "index";
    }

}
