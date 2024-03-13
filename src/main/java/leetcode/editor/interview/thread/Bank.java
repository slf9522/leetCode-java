package leetcode.editor.interview.thread;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Bank {

    int[] money = new int[]{2000, 2000};

    public synchronized void transfer(int m, int i, int j) throws InterruptedException {

        System.out.println("money: " + m + "from: " + i + "to: " + j);
        while (money[0] < m) {
            this.wait();
        }
        money[i] -= m;
        money[j] += m;
        System.out.println(Arrays.toString(money));
        this.notify();
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Runnable runnable = () -> {
            int m = (int) (1000 * Math.random());
            try {
                bank.transfer(m, 0, 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable2 = () -> {
            int m = (int) (10 * Math.random());
            try {
                bank.transfer(m, 1, 0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            es.submit(runnable);
            es.submit(runnable2);

        }
        es.shutdown();
    }

}
