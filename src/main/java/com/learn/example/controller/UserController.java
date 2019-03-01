package com.learn.example.controller;

import com.alibaba.fastjson.JSON;
import com.learn.example.service.UserService;
import com.learn.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author zjj
 * @date 2019/2/22 0022
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id) {
        User user = this.userService.getUserById(id);
        logger.info("-------method#getUserById() result :" + user.toString());
        return "index";
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public String getAllUser() {
        List<User> users = this.userService.getAllUser();
        logger.info("-------method#getUserById() result :" + JSON.toJSONString(users));
        return "index";
    }


}
