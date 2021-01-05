package com.qf;

import com.qf.zkClient.ZKClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundVersionable;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    private CuratorFramework c = ZKClient.cf();

    public static void main(String[] args) {
        System.out.println(ZKClient.cf());
    }

    @Test
    public void getChildren() throws Exception {
        List<String> list = c.getChildren().forPath("/");
        System.out.println(list);
    }

    @Test
    public void getData() throws Exception {
        byte[] bytes = c.getData().forPath("/qf");
        System.out.println(new String(bytes));
    }

    @Test
    public void create() throws Exception {
        String abc = c.create().withMode(CreateMode.PERSISTENT).forPath("/abc", "abc".getBytes());
        System.out.println(abc);

    }

    @Test
    public void update() throws Exception {
        Stat stat = c.setData().forPath("/abc", "bbb".getBytes());
        System.out.println(stat);

    }

    @Test
    public void delete() throws Exception {
        Void unused = c.delete().deletingChildrenIfNeeded().forPath("/abc");
        System.out.println(unused);

    }

    @Test
    public void stat() throws Exception {
        Stat stat = c.checkExists().forPath("/aaaaaaa");
        System.out.println(stat);

    }


}
