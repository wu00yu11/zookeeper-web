package com.learn.example.zookeeperweb.util;

import com.learn.example.zookeeperweb.exception.BizException;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Created by zjj on 2019/2/27 0027.
 */
public final class ModeUtil {
    private static final Logger logger = LoggerFactory.getLogger(ModeUtil.class);

    /**
     * 不支持实例化方法调用
     */
    private ModeUtil() {

    }

    public static final CreateMode CREATE_MODE(String mode) throws BizException {

        if (StringUtils.isEmpty(mode)) {
            throw new BizException("输入的节点模型,请检查!");
        }
        switch (mode.toUpperCase()) {
            case "PERSISTENT":
                return CreateMode.PERSISTENT;
            case "EPHEMERAL":
                return CreateMode.EPHEMERAL;
            case "PERSISTENT_SEQUENTIAL":
                return CreateMode.PERSISTENT_SEQUENTIAL;
            case "EPHEMERAL_SEQUENTIAL":
                return CreateMode.EPHEMERAL_SEQUENTIAL;
            default:
                throw new BizException("mode不在允许值范围内[PERSISTENT,EPHEMERAL,PERSISTENT_SEQUENTIAL,EPHEMERAL_SEQUENTIAL]");
        }
    }
}
