package leetcode.editor.script;

import java.util.Arrays;

import static org.apache.commons.lang3.ArrayUtils.isSorted;
import static org.apache.commons.lang3.ArrayUtils.swap;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j-1 >= 0 && nums[j]<nums[j-1]; j--) {
                swap(nums, j, j-1);
            }
        }
    }
}
