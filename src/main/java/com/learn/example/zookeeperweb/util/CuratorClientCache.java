package com.learn.example.zookeeperweb.util;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zjj
 * @date 2019/2/26 0026
 */
public enum CuratorClientCache {
    INSTANCE;
    private  Map<String, CuratorFramework> CLIENT_CACHE = new HashMap<>();

    public CuratorFramework getClient(String host){
        /**
         * 从缓存中取出,连接客户端
          */
        CuratorFramework  curatorFramework =  CLIENT_CACHE.get(host);
        if (curatorFramework == null){
            curatorFramework =  create(host);
            curatorFramework.start();
            CLIENT_CACHE.put(host,curatorFramework);
        }

        return curatorFramework;


    }

    private CuratorFramework create(String host){
        return CuratorFrameworkFactory.newClient(
                host,
                60000,
                5000,
                new RetryNTimes(3, 5000));
    }

    private class SessionConnectionStateListener implements ConnectionStateListener {
        private String zkRegPathPrefix;
        private String regContent;

        public SessionConnectionStateListener(String zkRegPathPrefix, String regContent) {
            this.zkRegPathPrefix = zkRegPathPrefix;
            this.regContent = regContent;
        }

        @Override
        public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState){
            if(connectionState == ConnectionState.LOST){
                while(true){
                    try {
                        System.err.println("我来了，嘿嘿");
                        if(curatorFramework.getZookeeperClient().blockUntilConnectedOrTimedOut()){
                            curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(zkRegPathPrefix, regContent.getBytes("UTF-8"));
                            break;
                        }
                    } catch (InterruptedException e) {
                        break;
                    } catch (Exception e){

                    }
                }
            }
        }
    }


}
