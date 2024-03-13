package leetcode.editor.interview.thread;

import org.apache.flink.util.concurrent.ExecutorThreadFactory;

import java.util.concurrent.*;

public class UsingBarriers {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        Runnable r1 = () -> {
            System.out.println("test1 " + Thread.currentThread().getName());
            cdl.countDown();
        };

        Runnable r2 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
            System.out.println("test2 " + Thread.currentThread().getName());
            cdl.countDown();
            throw new RuntimeException("test");
        };

        ExecutorService es = Executors.newFixedThreadPool(2, new ExecutorThreadFactory("test-enum-worker"));
        es.submit(r1);
        es.submit(r2);

        cdl.await(5, TimeUnit.SECONDS);
        es.shutdown();
        System.out.println("finish");
    }

    static class Factory extends ExecutorThreadFactory {

    }
}
