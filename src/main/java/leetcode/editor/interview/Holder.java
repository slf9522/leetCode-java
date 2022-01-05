package leetcode.editor.interview;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class Holder {
    private static ArrayList<WeakReference<Object>> refList = new ArrayList<>();

    public static void dump(){
        for (WeakReference<Object> objectWeakReference : refList) {
            if(objectWeakReference == null) System.out.println("null....");
            else System.out.println(objectWeakReference.get());
        }
    }

    public static void add(Runnable obj){
        refList.add(new WeakReference<Object>(obj));
    }
}