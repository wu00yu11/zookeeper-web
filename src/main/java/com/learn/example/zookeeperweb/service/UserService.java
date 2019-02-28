package com.learn.example.zookeeperweb.service;

import com.learn.example.zookeeperweb.model.User;

import java.util.List;

/**
 * @author zjj
 * @date 2019/2/22 0022
 */
public interface UserService {

    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * 获取所有用户信息
     *
     * @return
     */
    List<User> getAllUser();

}
