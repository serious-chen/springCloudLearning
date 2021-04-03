package myPain.easyTestCase;

import org.apache.zookeeper.ZooKeeper;

/**
 * @Description TODO
 * @Date 2021/3/18 1:28 下午
 **/
public class Cases {

    public static void main(String[] args) throws Exception{
        ZooKeeper zk = new ZooKeeper("", 3000, null);
        // 一致性要求高，在调用前可以先执行sync；
//        zk.sync();
    }
}
