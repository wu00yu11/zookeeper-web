package com.learn.example.zookeeperweb.model;

import java.io.Serializable;

/**
 *
 * @author zjj
 * @date 2019/2/27 0027
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -2695338534491734766L;

    private String mag;
    private String code;
    private T data;

    public String getMag() {
        return mag;
    }

    public Result setMag(String mag) {
        this.mag = mag;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Result setCode(String code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
}
