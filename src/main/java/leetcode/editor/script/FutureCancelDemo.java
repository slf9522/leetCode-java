package leetcode.editor.script;

import java.util.concurrent.*;

public class FutureCancelDemo {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Target> future = exec.submit(new DemoTask());
        TimeUnit.SECONDS.sleep(2); //给足时间让启动起来，但又不足以让其完成
        future.cancel(true);
    }

}

class Target { //任务目标

}

class DemoTask implements Callable<Target> { //任务
    private static int counter = 0;
    private final int id = counter++;

    @Override
    public Target call() throws Exception {
        System.out.println(this + " start...");
        TimeUnit.SECONDS.sleep(5); //模拟任务运行需要的时间
        System.out.println(this + " completed!");
        return new Target();
    }

    @Override
    public String toString() {
        return "Task[" + id + "]";
    }
}