//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
//
// 
//Follow-up: Can you come up with an algorithm that is less than O(n2) time comp
//lexity? Related Topics Array Hash Table 
// 👍 22705 👎 764


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 找到数组中sum为target的数字
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numMap = new HashMap<>();
            int i = 0;
            for (; i < nums.length; i++) {
                if (numMap.containsKey(target - nums[i])) {
                    break;
                } else {
                    numMap.put(nums[i], i);
                }
            }
            return new int[]{i, numMap.get(target - nums[i])};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.putIfAbsent(nums[i], new ArrayList<>());
            indexMap.get(nums[i]).add(i);
        }
        // Onln(n)
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if ((nums[i] + nums[j]) < target) {
                i++;
            } else if ((nums[i] + nums[j]) > target) {
                j--;
            } else {
                break;
            }
        }
        if (nums[i] == nums[j]) {
            return new int[]{indexMap.get(nums[i]).get(0), indexMap.get(nums[i]).get(1)};
        } else {
            return new int[]{indexMap.get(nums[i]).get(0), indexMap.get(nums[j]).get(0)};
        }
    }
}


