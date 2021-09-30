//Given an integer array nums and an integer k, modify the array in the followin
//g way: 
//
// 
// choose an index i and replace nums[i] with -nums[i]. 
// 
//
// You should apply this process exactly k times. You may choose the same index 
//i multiple times. 
//
// Return the largest possible sum of the array after modifying it in this way. 
//
//
// 
// Example 1: 
//
// 
//Input: nums = [4,2,3], k = 1
//Output: 5
//Explanation: Choose index 1 and nums becomes [4,-2,3].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,-1,0,2], k = 3
//Output: 6
//Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
// 
//
// Example 3: 
//
// 
//Input: nums = [2,-3,-1,5,-4], k = 2
//Output: 13
//Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -100 <= nums[i] <= 100 
// 1 <= k <= 104 
// 
// Related Topics Array Greedy Sorting 
// 👍 730 👎 67


package leetcode.editor.en;

import java.util.Arrays;
import java.util.PriorityQueue;

// 用优先队列来实现 https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/discuss/252228/A-very-simple-java
//-solution
public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new MaximizeSumOfArrayAfterKNegations().new Solution();
        System.out.println(solution.largestSumAfterKNegations2(new int[]{-8, 3, -5, -3, -5, -2}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
//            nlog(n)
            Arrays.sort(nums);
            int i = 0;
            while (i < nums.length && nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
                i++;
            }
            if (k % 2 == 0) return Arrays.stream(nums).sum();

            Arrays.sort(nums);
            nums[0] = -nums[0];
            return Arrays.stream(nums).sum();
        }

        public int largestSumAfterKNegations2(int[] nums, int k) {
//            nlog(n) 通过优先级队列保证有序性
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int a : nums) pq.add(a);
            while (k-- > 0) pq.add(-pq.poll());
            return pq.stream().reduce(Integer::sum).get();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}