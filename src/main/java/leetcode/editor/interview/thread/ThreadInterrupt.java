package leetcode.editor.interview.thread;

public class ThreadInterrupt {


    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                System.out.println("not interrupt " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
//                throw new RuntimeException("Interrupted", e);

            }
        };
        Thread t = new Thread(runnable);
        t.start();

        Thread.sleep(1000);
        t.interrupt();
        System.out.println(t.isInterrupted());
        System.out.println(t.isAlive());


    }

    static class Print implements Runnable{
        @Override
        public void run() {

        }
    }
}
