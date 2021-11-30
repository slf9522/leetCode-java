package leetcode.editor.training.reflect;

/**
 * @ClassName ReflectionDemo
 * @Description //TODO
 * @Author fangjiaxin
 * @Date 2021/11/25
 */
public class ReflectionDemo {
    public int pubVar;
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void privateMethod(int num) {
        System.out.println("privateMethod" + num);
    }
}
