package leetcode.editor.script;

import java.util.concurrent.BlockingQueue;

public class Consumer3 implements Runnable{
    //共享资源对象
    private final BlockingQueue sharedQueue;
    public Consumer3(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run() {
        while(true){
            try {
                Person3 p = (Person3) sharedQueue.take();
                System.out.println(p.getName()+"---"+p.getAge());
            } catch (InterruptedException ex) {

            }
        }//while
    }

}