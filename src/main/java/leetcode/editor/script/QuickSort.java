package leetcode.editor.script;


import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class QuickSort {
    public static void main(String[] args) {

    }

    public void sort(int[] num, int lo, int hi) {
        if (lo >= hi) return;

        int p = partition(num, lo, hi);
        sort(num, lo, p - 1);
        sort(num, p + 1, hi);
    }

    int partition(int[] num, int lo, int hi) {
        int v = num[0];
        int l = lo + 1; // [lo, l) <= pivot
        int r = hi; // (r, hi] > pivot
        while (l <= r) {

            if (l < hi && num[l] <= v) {
                l++;
            }
            // 判断条件不能重复 num[r] >= v 就不行了，l和r可能超过边界，比如全部都小于v的情况
            if (r > lo + 1 && num[r] > v) {
                r--;
            }

            if (l > r) {
                break;
            }

            swap(num, l, r);
            // [lo, l] <=pivot [r, hi] >= pivot
        }
        // l>r,所以选r交换
        swap(num, lo, r);

        return r;

    }

    int partition2(int[] num, int lo, int hi) {
        int v = num[lo];
        int i = lo + 1, j = hi;
        while (i <= j) {
            while (i < hi && num[i] < v) i++;
            while (j > lo && num[j] > v) j--;
            if (i >= j) break;
            swap(num, i, j);
        }
        swap(num, lo, j);
        return j;
    }

    void shuffle(int[] num) {
        Random random = new Random();
        int n = num.length;
        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n - i);
            swap(num, i, r);
        }
    }
}
