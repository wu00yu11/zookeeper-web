package com.learn.example.controller;

import com.alibaba.fastjson.JSON;
import com.learn.example.service.ZkCfgService;
import com.learn.example.model.ZkCfg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * zookeeper配置项管理
 *
 * @author zjj
 * @date 2019/2/28 0028
 */
@Controller
@RequestMapping(value = "/zkCfg")
public class ZkCfgController {

    private static final Logger logger = LoggerFactory.getLogger(ZkCfgController.class);

    @Resource
    private ZkCfgService zkCfgService;

    @PostMapping("/add")
    public String add(ZkCfg zkCfg) {
        zkCfgService.add(zkCfg);
        return "index";
    }

    @PostMapping("/update")
    public String update(ZkCfg zkCfg) {
        zkCfgService.update(zkCfg);
        return "index";
    }

    @PostMapping("/delete")
    public String delete(ZkCfg zkCfg) {
        zkCfgService.delete(zkCfg);
        return "index";
    }

    @GetMapping("/query")
    public String query(ZkCfg zkCfg) {
        logger.info("#query() :: params = "+ JSON.toJSONString(zkCfg));
       List<ZkCfg> cfgs=  zkCfgService.query(zkCfg);
       logger.info("#query() :: "+ JSON.toJSONString(cfgs));
       return "index";
    }

}
