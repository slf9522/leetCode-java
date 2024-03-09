package leetcode.editor.interview;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Weiruan3 {
    public static void main(String[] args) {

        Iterator<Integer> iter = IntStream.iterate(0, i -> i + 1).limit(10).iterator();
        Buffer buffer = new Buffer();
        IterImpl i1 = new IterImpl(iter, buffer);
        IterImpl i2 = new IterImpl(iter, buffer);
        while(i1.hasNext() || i2.hasNext()){
            System.out.println(i1.next());
            System.out.println(i2.next());
        }
    }


    static class IterImpl implements Iterator<Integer> {

        Iterator<Integer> input;
        int cnt = 0;

        Buffer bf;

        public IterImpl(Iterator<Integer> iter, Buffer buffer) {
            input = iter;
            bf = buffer;
        }

        @Override
        public boolean hasNext() {
            if (cnt < bf.maxSize) {
                return true;
            } else {
                return this.input.hasNext();
            }
        }

        @Override
        public Integer next() {
            if (cnt < bf.maxSize) {
                cnt++;
                return bf.bq.poll();
            } else {
                if (this.input.hasNext()) {
                    cnt++;
                    int val = this.input.next();
                    bf.add(val);
                    return val;
                }
                return null;
            }
        }
    }

    static class Buffer {
        ArrayBlockingQueue<Integer> bq = new ArrayBlockingQueue<>(100);
        int maxSize = 0;

        public Buffer() {

        }

        public synchronized void add(int ele) {
            bq.offer(ele);
            maxSize++;
        }
    }
}
