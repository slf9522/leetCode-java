package leetcode.editor.script;

public class Bucket {
    private int capacity;
    private int rateLimit;

    private long lastTime;

    private int waterMark = 0;

    public Bucket(int capacity, int rateLimit){
        this.capacity = capacity;
        this.rateLimit = rateLimit;
        this.lastTime = System.currentTimeMillis();
    }

    public synchronized boolean addNewRequest(){
        long current = System.currentTimeMillis();
        waterMark = (int) (waterMark - (current - lastTime) * rateLimit);
        waterMark++;
        if(waterMark < capacity){
            lastTime = current;
            return true;
        } else {
            return false;
        }
    }
}
