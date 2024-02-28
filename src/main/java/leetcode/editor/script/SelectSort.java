package leetcode.editor.script;

import static org.apache.commons.lang3.ArrayUtils.swap;

// select the minimum object and set to index
public class SelectSort {
    public static void main(String[] args) {

    }

    void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            for (int j = 1; j < nums.length; j++) {
                if(v<nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }
}
