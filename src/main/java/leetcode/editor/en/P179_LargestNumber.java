//Given a list of non-negative integers nums, arrange them such that they form 
//the largest number and return it. 
//
// Since the result may be very large, so you need to return a string instead 
//of an integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,2]
//Output: "210"
// 
//
// Example 2: 
//
// 
//Input: nums = [3,30,34,5,9]
//Output: "9534330"
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array String Greedy Sorting 👍 7830 👎 636


package leetcode.editor.en;

import java.util.*;

/**
 * Largest Number
 *
 * @author JX
 * @date 2024-02-28 11:28:48
 */
public class P179_LargestNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P179_LargestNumber().new Solution();
        System.out.println(solution.largestNumber(new int[]{0,0}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            List<String> numString = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                numString.add(String.valueOf(nums[i]));
            }

            Collections.sort(numString, (a, b) -> (a + b).compareTo(b + a));
            Collections.reverse(numString);
            String res = String.join("", numString);
            if(Integer.valueOf(res) == 0) return "0";
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
