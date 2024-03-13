package leetcode.editor.interview.thread;

import java.util.concurrent.*;

public class UsingCyclicBarrier {


    public static void main(String[] args) {

        CyclicBarrier cb = new CyclicBarrier(10);
        ExecutorService es = Executors.newFixedThreadPool(10);

        Runnable task = () -> {
            System.out.println("doing " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println("done " + Thread.currentThread().getName());
        };

        for (int i = 0; i < 10; i++) {
            es.submit(task);
        }
//        es.shutdown();
    }


}
