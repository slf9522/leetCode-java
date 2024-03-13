package leetcode.editor.interview.thread;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class UsingCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();
        ExecutorService es = Executors.newFixedThreadPool(10);

        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(()-> random.nextInt(140), es);
        String str = cf.thenApplyAsync((n)-> Integer.toString(n), es).get();
        System.out.println(str);

        // mapping
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(()-> random.nextInt(140), es);
        // combine
        System.out.println(cf.thenCombine(cf2, (a,b)-> {
            System.out.println(a);
            System.out.println(b);
            return a+b;
        }).get());

        Supplier<Double> s = ()->{
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
            return random.nextDouble();
        };

        CompletableFuture<Double> f1 = CompletableFuture.supplyAsync(s);
        CompletableFuture<Double> f2 = CompletableFuture.supplyAsync(s);
        CompletableFuture.anyOf(f1, f2).thenRun(()->{
            System.out.println("test");
        });

        es.shutdownNow();
    }
}
