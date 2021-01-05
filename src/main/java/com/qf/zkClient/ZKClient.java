package com.qf.zkClient;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZKClient {
    public static CuratorFramework cf() {
        RetryPolicy policy = new ExponentialBackoffRetry(3000, 2);
        CuratorFramework cf = CuratorFrameworkFactory.builder().connectString("192.168.245.131:2181,192.168.245.131:2182,192.168.245.131:2183")
                .retryPolicy(policy).build();
        cf.start();
        return cf;
    }
}
