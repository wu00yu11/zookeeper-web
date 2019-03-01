package com.learn.example.controller;

import com.learn.example.util.CuratorClientCache;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zjj on 2019/2/26 0026.
 */
public class ZkClientTest {
    private static final Logger logger = LoggerFactory.getLogger(ZkClientTest.class);
    @Test
    public void ZkClientTest1() {
            CuratorFramework framework = CuratorClientCache.INSTANCE.getClient("192.168.91.140:2181");
            try {
                framework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                        .forPath("/test/path","haha".getBytes());
                logger.info("测试结果: "+new String(framework.getData().forPath("/test/path")));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
}
