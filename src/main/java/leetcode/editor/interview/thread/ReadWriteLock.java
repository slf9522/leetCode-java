package leetcode.editor.interview.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() throws InterruptedException {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        if (!readLock.tryLock(10, TimeUnit.SECONDS)) {
            System.out.println("not get read lock");

        } else {
            try {
                System.out.println("read " + Thread.currentThread().getName());
            } finally {
                readLock.unlock();
            }
        }
    }

    public void write() throws InterruptedException {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        if (!writeLock.tryLock(50, TimeUnit.SECONDS)) {
            System.out.println("not get write lock");

        } else {
            try {
                System.out.println("write " + Thread.currentThread().getName());
            } finally {
                writeLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock rw = new ReadWriteLock();
        Runnable r = ()->{
            try {
                rw.read();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable w = ()->{
            try {
                rw.write();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            es.submit(r);
            es.submit(w);
        }
//        es.shutdownNow();
        es.awaitTermination(10, TimeUnit.SECONDS);
        es.shutdownNow();

    }
}
