package leetcode.editor.script;

import java.util.concurrent.BlockingQueue;

public class Producer3 implements Runnable{
    //共享资源对象
    private final BlockingQueue sharedQueue;

    public Producer3(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run() {
        //生产对象
        for(int i = 0 ; i < 50 ; i++){
            //如果是偶数，那么生产对象 liu--11;如果是奇数，则生产对象 zhi--21
            Person3 person;
            if(i%2==0){
                person = new Person3("liu"+ i, 11);
            }else{
                person = new Person3("zhi"+ i, 21);
            }
            try {
                sharedQueue.put(person);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}