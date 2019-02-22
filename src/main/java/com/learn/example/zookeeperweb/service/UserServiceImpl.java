package com.learn.example.zookeeperweb.service;

import com.learn.example.zookeeperweb.dao.UserDao;
import com.learn.example.zookeeperweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author zjj
 * @date 2019/2/22 0022
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return this.userDao.getUserById(userId);
    }

    @Override
    public List<User> getAllUser() {
        return this.userDao.getAllUser();
    }
}
