package com.qf.zkClient;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

public class ZKTest {

    CuratorFramework c = ZKClient.cf();

    @Test
    public void listener() throws Exception {
        NodeCache nodeCache = new NodeCache(c, "/abc");
        nodeCache.start();
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                byte[] data = nodeCache.getCurrentData().getData();
                Stat stat = nodeCache.getCurrentData().getStat();
                String path = nodeCache.getCurrentData().getPath();
                System.out.println("监听的节点是：" + path);
                System.out.println("节点现在的数据是：" + new String(data, "UTF-8"));
                System.out.println("节点状态是：" + stat);
            }
        });
        System.out.println("开始监听！！");
        System.in.read();
    }

}
