package leetcode.editor.script;

public class MergeSort {

    void sort(int[] num, int lo, int hi) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo) / 2;

        sort(num, lo, mid);
        sort(num, mid + 1, hi);
        merge(num, lo, mid, hi);
    }

    void merge(int[] num, int lo, int mid, int hi) {
        int[] tmp = new int[hi - lo + 1];
        for (int i = lo; i < hi; i++) {
            tmp[i] = num[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i == mid + 1) {
                num[k] = tmp[j++];
            } else if (j == hi) {
                num[k] = tmp[i++];
            } else if (tmp[i] < tmp[j]) {
                num[k] = tmp[i++];
            } else {
                num[k] = tmp[j++];
            }
        }

    }
}
