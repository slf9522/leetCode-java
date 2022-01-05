package leetcode.editor.script;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// 用array blocking queue 实现生产者消费者模型
public class TestPeople3 {
    public static void main(String[] args) {
        BlockingQueue sharedQueue = new LinkedBlockingQueue();
        Producer3 t1 = new Producer3(sharedQueue);
        Consumer3 t2 = new Consumer3(sharedQueue);

        new Thread(t1).start();
        new Thread(t2).start();
    }
}