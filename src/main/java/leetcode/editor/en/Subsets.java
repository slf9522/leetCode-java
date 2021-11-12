//Given an integer array nums of unique elements, return all possible subsets (t
//he power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 7265 👎 126


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets0(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());

            for (int i = 0; i < nums.length; i++) {
                int finalI = i;
                List<List<Integer>> tmp = res.stream().map(l -> {
                    List<Integer> copy = new ArrayList<>(l);
                    l.add(nums[finalI]);
                    return copy;
                }).collect(Collectors.toList());
                res.addAll(tmp);
            }

            return res;
        }

        // 递归解法
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(nums, res, 0, new ArrayList<>());
            return res;
        }

        private void backtrack(int[] nums, List<List<Integer>> res, int start, List<Integer> sub) {
            res.add(sub);
            for (int i = start; i < nums.length; i++) {
                sub.add(nums[i]);
                backtrack(nums, res, i + 1, new ArrayList<>(sub));
                sub.remove(sub.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}