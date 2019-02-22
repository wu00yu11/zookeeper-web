package com.learn.example.zookeeperweb.dao;

import com.learn.example.zookeeperweb.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author zjj
 * @date 2019/2/22 0022
 */
@Repository
public interface UserDao {

    /**
     * 根据userId查询对应用户
     * @param userId
     * @return
     */
     User getUserById(Integer userId);


    /**
     * 查询所有用户信息
     * @return
     */
     List<User> getAllUser();
}
