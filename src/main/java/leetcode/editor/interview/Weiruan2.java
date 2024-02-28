package leetcode.editor.interview;


import java.util.LinkedList;

import static java.util.Objects.hash;

public class Weiruan2 {



    int cap = 0;
    LinkedList[] array;
    public Weiruan2(int capacity){
        cap = capacity;
        // hash map put get delete
        array = new LinkedList[cap];
    }
    public void put(Object key, Object value) {
        int hashV  = hash(key);
        int index = hashV & cap;

        if(array[index] == null) {
            array[index] = new LinkedList<>();
        }
        addIndex(array[index], key, value);
    }

    public Object get(Object key) {
        int hashV  = hash(key);
        int index = hashV & cap;

        if(array[index] == null) return null;
        return getFromIndex(array[index], key);
    }

    public boolean delete(Object key) {
        int hashV  = hash(key);
        int index = hashV & cap;

        if(array[index] == null) return false;
        return deleteFromIndex(array[index], key);
    }

    class Node {
        Object key;
        Object value;

        public Node(Object key, Object value){
            key = key;
            value = value;
        }
    }

    void addIndex(LinkedList<Node> l, Object key, Object value) {
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i).key.equals(key)) {
                l.get(i).value = value;
            }
        }
        l.addLast(new Node(key, value));
    }

    Object getFromIndex(LinkedList<Node> l, Object key){
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i).key.equals(key)) {
                return l.get(i);
            }
        }
        return null;
    }

    boolean deleteFromIndex(LinkedList<Node> l, Object key){
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i).key.equals(key)) {
                l.remove(i);
                return true;
            }
        }
        return false;
    }

}
