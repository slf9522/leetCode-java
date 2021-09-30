//Given an integer array nums and an integer k, return true if there are two dis
//tinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <
//= k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1
//Output: true
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 0 <= k <= 105 
// 
// Related Topics Array Hash Table Sliding Window 
// 👍 1701 👎 1562


package leetcode.editor.en;

import java.util.HashSet;

public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int i = 0, j = 0;
            HashSet<Integer> window = new HashSet<>();

//            k=1 can add 2 so j==k， 还要加上数组长度判断
            while (j <= k && j < nums.length) {
                if (!window.add(nums[j++])) return true;
            }

            while (j < nums.length) {
                window.remove(nums[i++]);
                if (!window.add(nums[j++])) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}