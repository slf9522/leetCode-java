//Given an integer array nums that may contain duplicates, return all possible s
//ubsets (the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order. 
//
// 
// Example 1: 
// Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// Related Topics Array Backtracking Bit Manipulation 
// 👍 3605 👎 126


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/subsets-ii/discuss/30168/C%2B%2B-solution-and-explanation
 * 1、首先分析一共有多少种子集，没有重复元素2^n，有重复元素（a1, a2, a3) 重复(n1, n2, n3) 一共(n1+1)(n2+1)(n3+1)
 * 2、
 */
public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup0(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; ) {
                int finalI = i;
                int cnt = 0;
                while (i + cnt < nums.length && nums[i + cnt] == nums[i]) cnt++;
//                注意重复元素的移动距离
                i += cnt;

//                注意while中是针对上一轮res的结果进行操作，所以需要临时的subRes存储结果
                List<List<Integer>> subRes = new ArrayList<>();
                while (cnt > 0) {
                    int finalCnt = cnt;
                    List<List<Integer>> next = res.stream().map(l -> {
                        List<Integer> copy = new ArrayList<>(l);
                        copy.addAll(Collections.nCopies(finalCnt, nums[finalI]));
                        return copy;
                    }).collect(Collectors.toList());
                    subRes.addAll(next);
                    cnt--;
                }
                res.addAll(subRes);
            }
            return res;
        }

        // 递归解法
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            backtrack(nums, res, 0, new ArrayList<>());
            return res;
        }

        private void backtrack(int[] nums, List<List<Integer>> res, int start, List<Integer> sub) {
            res.add(sub);
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[start]) continue;
                backtrack(nums, res, i + 1, new ArrayList<>(sub));
                sub.remove(sub.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}