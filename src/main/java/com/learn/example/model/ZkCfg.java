package com.learn.example.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zjj
 * @date 2019/2/25 0025
 */
@Data
public class ZkCfg implements Serializable {
    private static final long serialVersionUID = 4120637624765925985L;

    private Integer id;

    private String host;

    private String name;

    private String desc;


}
