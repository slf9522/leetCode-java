package leetcode.editor.script;

import org.aspectj.weaver.ast.Test;

/**
 * @ClassName TryTest
 * @Description //TODO
 * @Author fangjiaxin
 * @Date 2021/12/30
 */
public class TryTest {

    /**
     * 输出结果
     * -- catch --
     * b:true
     * -- finally --
     * b:false
     * false
     *
     * @param args
     */
    public static void main(String[] args) {
        TryTest t = new TryTest();
        System.out.println(t.test2());
    }

    public boolean Test1() {
        boolean b = true;
        try {
            int i = 10 / 0;
            System.out.println("i = " + i);
            return true;
        } catch (Exception e) {
            System.out.println(" -- catch --");
            System.out.println("b:" + b);
            return b = false;
        } finally {
            System.out.println(" -- finally --");
            System.out.println("b:" + b);
        }
    }

    /**
     * 程序在catch中执行throw语句时并不会立即抛出异常，而是去寻找该异常处理流中是否包含finally块。
     * 如果没有finally块，程序立即抛出异常；
     * 如果有finally块，程序立即开始执行finally块——只有当finally块执行完成后，系统才会再次跳回来抛出异常。
     * 如果finally块里使用return语句来结束方法，系统将不会跳回catch块去抛出异常。
     * @return
     */
    public static int test2() {
        int count = 5;
        try {
            throw new RuntimeException ("测试异常1");
        } catch (RuntimeException e) {
            System.out.println(e.toString());
            throw new RuntimeException ("测试异常2");
        } catch (Exception e) {
            System.out.println(e.toString());
            return 2;
        } finally {
            System.out.println("finally()执行");
            // 注释掉以后会抛出异常，否则直接return 异常被吞掉
//            return count;
        }
    }
}
