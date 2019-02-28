package com.learn.example.zookeeperweb.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zjj
 * @date 2019/2/22 0022
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -523878900000009706L;

    private Integer id;
    private String userName;
    private String passWord;
    /**
     * 1.admin
     * 2.common
     */
    private String userType;
    private Integer enabled;
    /**
     * 真实姓名
     **/
    private String realName;
    /**
     * 电话号码
     **/
    private Integer phoneNumber;
    /**
     * 座机号码
     **/
    private String tel;
    private String qq;
    private String email;

}
