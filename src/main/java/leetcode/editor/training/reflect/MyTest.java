package leetcode.editor.training.reflect;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println(Arrays.toString(args));
        r.run();
    }
}