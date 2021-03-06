package com.learn.example.controller;

import com.learn.example.service.ZkService;
import com.learn.example.exception.BizException;
import com.learn.example.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zjj
 * @date 2019/2/22 0022
 */
@RestController
@RequestMapping(value = "/zk")
public class ZookeeperController {
    private static final Logger logger = LoggerFactory.getLogger(ZookeeperController.class);

    @Autowired
    private ZkService zkService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(String host, String path, String mode, String data) {
        Result result = new Result();
        try {
            zkService.add(host, path, mode, data);
        } catch (BizException e) {
            logger.error("#add() ::", e);
            result.setCode(e.getCode()).setMag(e.getMsg()).setData(null);
            return result;
        }
        return result.setCode("0000").setMag("处理成功").setData(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(String host, String path, String data) {
        Result result = new Result();
        try {
            zkService.update(host, path, data);
        } catch (BizException e) {
            logger.error("#update() ::", e);
            result.setCode(e.getCode()).setMag(e.getMsg()).setData(null);
            return result;
        }
        return result.setCode("0000").setMag("处理成功").setData(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(String host, String path) {
        Result result = new Result();
        try {
            zkService.delete(host, path);
        } catch (BizException e) {
            logger.error("#delete() ::", e);
            result.setCode(e.getCode()).setMag(e.getMsg()).setData(null);
            return result;
        }
        return result.setCode("0000").setMag("处理成功").setData(null);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Result<String> query(String host, String path) {
        Result result = new Result();
        String data = "";
        try {
            data = zkService.queryData(host, path);
        } catch (BizException e) {
            logger.error("#queryData() ::", e);
            result.setCode(e.getCode()).setMag(e.getMsg()).setData(data);
            return result;
        }
        return result.setCode("0000").setMag("处理成功").setData(data);
    }

    @RequestMapping(value = "/nodeList", method = RequestMethod.GET)
    public Result<List<String>> nodeList(String host, String path) {
        Result result = new Result();
        List<String> paths = null;
        try {
            paths = zkService.nodeList(host, path);
        } catch (BizException e) {
            logger.error("#nodeList() ::", e);
            result.setCode(e.getCode()).setMag(e.getMsg()).setData(null);
            return result;
        }
        return result.setCode("0000").setMag("处理成功").setData(paths);
    }

    @RequestMapping(value = "/monitor", method = RequestMethod.GET)
    public Result monitor() {
        Result result = new Result();
        try {
            zkService.monitor();
        } catch (BizException e) {
            logger.error("#monitor() ::", e);
            result.setCode(e.getCode()).setMag(e.getMsg()).setData(null);
            return result;
        }
        return result.setCode("0000").setMag("处理成功").setData(null);
    }


}
