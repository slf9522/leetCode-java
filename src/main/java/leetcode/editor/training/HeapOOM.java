package leetcode.editor.training;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName HeapOOM
 * @Description //TODO
 * @Author fangjiaxin
 * @Date 2021/12/2
 */
public class HeapOOM {
    static class OOMObject {

    }

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
//        List<OOMObject> list = new ArrayList<>();
//        while (true) {
//            list.add(new OOMObject());
//        }

//        HeapOOM oom = new HeapOOM();
//        try {
//            oom.stackLeak();
//        } catch (Throwable e) {
//            System.out.println("stack length: " + oom.stackLength);
//            throw e;
//        }

        Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
