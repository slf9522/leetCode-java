//Given an integer array nums that may contain duplicates, return all possible 
//subsets (the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
// Example 2: 
// Input: nums = [0]
//Output: [[],[0]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics Array Backtracking Bit Manipulation 👍 9413 👎 285


package leetcode.editor.en;

import org.aspectj.tools.ant.taskdefs.Ajdoc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Subsets II
 *
 * @author DY
 * @date 2024-02-11 15:42:43
 */
public class P90_SubsetsIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P90_SubsetsIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtrace(0, nums);
            return res;
        }

        private void backtrace(int start, int[] nums) {
            res.add(new LinkedList<>(track));

            for (int j = start; j < nums.length; j++) {
                if(start > 0 && nums[start] == nums[start-1]){
                    continue;
                } else {
                    track.add(nums[start]);
                    backtrace(start + 1, nums);
                    track.removeLast();
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
