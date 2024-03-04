//Given an integer array nums, rotate the array to the right by k steps, where 
//k is non-negative. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁵ 
// 
//
// 
// Follow up: 
//
// 
// Try to come up with as many solutions as you can. There are at least three 
//different ways to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
//
// Related Topics Array Math Two Pointers 👍 17334 👎 1900


package leetcode.editor.en;

import java.util.Arrays;

/**
 * Rotate Array
 *
 * @author JX
 * @date 2024-03-04 14:59:19
 */
public class P189_RotateArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P189_RotateArray().new Solution();
        solution.rotate(new int[]{-1}, 2);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            int l = nums.length;
            int[] tmp = new int[2 * l];
            // k 可能很大
            k = k%l;

            for (int i = l - 1; i >= 0; i--) {
                int next = i + k;
                tmp[next] = nums[i];
            }

            for (int i = 0; i < k; i++) {
                nums[i] = tmp[l+i];
            }

            for (int i = k; i < l; i++) {
                nums[i] = tmp[i];
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
