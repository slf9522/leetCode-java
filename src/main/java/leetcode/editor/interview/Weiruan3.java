package leetcode.editor.interview;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Weiruan3 {
    public static void main(String[] args) {
        // 把stream和iterator的操作熟悉了

        Iterator<Integer> iter = IntStream.iterate(0, i -> i + 2).iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    void process(Iterator iter) {

    }

    // java iterator
    public static List<Iter> getIterator(Iter input) {
        return null;
    }

    interface Iter {
        boolean hasNext();

        int next();
    }

    class IterImpl implements Iter {

        Iter input;
        int cnt = 0;

        Buffer bf;

        public IterImpl(Iter iter, Buffer buffer) {
            input = iter;
            bf = buffer;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            if (cnt > bf.cnt) {
                int val = input.next();
                bf.bf[++bf.cnt] = val;
                return val;
            } else {
                int val = bf.bf[cnt++];
                return val;
            }
        }
    }

    class Buffer {
        int[] bf;

        // total count
        int cnt;

        int size;

        int window;
    }
}
