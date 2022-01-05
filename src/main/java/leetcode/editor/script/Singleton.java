package leetcode.editor.script;

// 单例：懒汉式
public class Singleton {

    private static volatile Singleton instance = null;

    // private 保证不被其他对象调用
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}