package leetcode.editor.script;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDumpHeap {
    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();

        try {
            while (true) {
                list.add(new Object()); // 不断向列表中添加对象
            }
        } catch (OutOfMemoryError e) {
            System.out.println("内存溢出错误：" + e.getMessage());
        }
    }
}
