package com.learn.example.dao;

import com.learn.example.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjj
 * @date 2019/2/22 0022
 */
@Repository
public interface UserDao {

    /**
     * 根据userId查询对应用户
     *
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);


    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> getAllUser();
}
