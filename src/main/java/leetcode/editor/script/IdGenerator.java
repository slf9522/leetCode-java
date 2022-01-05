package leetcode.editor.script;

import java.util.concurrent.atomic.AtomicLong;


// 饿汉式
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);

    // 在加载的时候创建静态实例
    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}