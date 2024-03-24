package leetcode.editor.script;

public class LeakyBucket {
    private int capacity; // 漏桶容量
    private int rateLimit; // 漏水速率，每秒处理的请求数量
    private int waterLevel; // 漏桶中的水量
    private long lastLeakTime; // 上一次漏水的时间戳
    public LeakyBucket(int capacity, int rateLimit) {
    this.capacity = capacity;
    this.rateLimit = rateLimit;
    this.waterLevel = 0; 
    this.lastLeakTime = System.currentTimeMillis();
}

private long currentTimeInSeconds() {
    return System.currentTimeMillis() / 1000;
}

public synchronized void processRequest() {
    // 获取当前时间戳
    long currentTime = currentTimeInSeconds();
    // 计算时间间隔
    long timeInterval = currentTime - lastLeakTime;
    // 漏水：水量减少，但不能小于0
    waterLevel = Math.max(0, waterLevel - (int) (timeInterval * rateLimit));
    // 更新上一次漏水的时间戳
    lastLeakTime = currentTime;
    // 处理新的请求
    if (waterLevel < capacity) {
        waterLevel++;
        // 处理请求的逻辑，可以是放入队列、执行任务等
        System.out.println("Request processed successfully.");
    } else {
        // 请求被拒绝，漏桶已满
        System.out.println("Request rejected. Bucket is full.");
    }

}

public static void main(String[] args) {
    // 示例用法
    LeakyBucket bucket = new LeakyBucket(10, 2);
    // 模拟处理请求
    for (int i = 0; i < 15; i++) {
        bucket.processRequest();
    }
}

}