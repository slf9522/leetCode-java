//Given an array of non-negative integers nums, you are initially positioned at 
//the first index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// You can assume that you can always reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics Array Dynamic Programming Greedy 
// 👍 5480 👎 212


package leetcode.editor.en;

import java.util.Arrays;

public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        System.out.println(solution.jump(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int l = nums.length;
            int[] jump = new int[l];
            Arrays.fill(jump, Integer.MAX_VALUE);
            jump[0] = 0;
            int maxDis = 0;
            for (int i = 0; i < l && maxDis < l - 1; i++) {
                for (int j = maxDis - i + 1; j <= nums[i] && i + j < l; j++) {
                    jump[i + j] = Math.min(jump[i + j], jump[i] + 1);
                }
                maxDis = Math.max(maxDis, i + nums[i]);
            }
            return jump[l - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}