package com.learn.example.zookeeperweb.exception;

import lombok.Data;

/**
 * @author zjj
 * @date 2019/2/27 0027
 */
@Data
public class BizException extends Exception {
    private static final long serialVersionUID = 6568018149952908017L;
    private String msg;
    private String code;

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.msg = message;
    }

    public BizException(String msg, String code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }


}
