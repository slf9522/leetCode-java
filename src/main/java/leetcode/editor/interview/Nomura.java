package leetcode.editor.interview;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Nomura {
    public static void main(String[] args) throws InterruptedException {


//        List<Thread> threadList = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            Thread t = new Thread(new Print(i, 100));
//            threadList.add(t);
//            t.start();
//        }
//
//        for (int i = 0; i < 4; i++) {
//            threadList.get(i).join(10000);
//        }


        List<Print> runnableList = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            Print print = new Print(i, 100);
            runnableList.add(print);
            pool.submit(print);
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.SECONDS);
        // 会主动interrupt线程池
        pool.shutdownNow();


        System.out.println("test");
        Thread.sleep(1000 * 20);

    }

    public static class Print implements Runnable {

        int start;
        int end;


        public Print(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end && !Thread.currentThread().isInterrupted(); ) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("interrupted" + Thread.currentThread().getName());
                    break;
                }
                i += 4;
            }
        }
    }


    // four threads, printing member
    // wait 1 min four thread to stop
    // proceed main thread
}
