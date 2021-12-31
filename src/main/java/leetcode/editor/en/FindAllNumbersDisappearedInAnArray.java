//Given an array nums of n integers where nums[i] is in the range [1, n], return
// an array of all the integers in the range [1, n] that do not appear in nums. 
//
// 
// Example 1: 
// Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
// Example 2: 
// Input: nums = [1,1]
//Output: [2]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 
// Follow up: Could you do it without extra space and in O(n) runtime? You may a
//ssume the returned list does not count as extra space. 
// Related Topics Array Hash Table 
// 👍 5744 👎 351


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers2(int[] nums) {
            List<Integer> res = new ArrayList<>();
            Arrays.sort(nums);
            int i = 0, j = 0;
            for (; i < nums.length && j < nums.length; i++) {
                while (i + 1 != nums[j] && i < nums.length) {
                    res.add(i + 1);
                    i++;
                }
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
                j++;
            }
            while (i < nums.length) {
                res.add(i + 1);
                i++;
            }
            return res;
        }

        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; ++i)
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > 0)
                    res.add(i + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}