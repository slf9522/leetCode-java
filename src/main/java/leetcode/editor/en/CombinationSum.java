//Given an array of distinct integers candidates and a target integer target, re
//turn a list of all unique combinations of candidates where the chosen numbers su
//m to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. T
//wo combinations are unique if the frequency of at least one of the chosen number
//s is different. 
//
// It is guaranteed that the number of unique combinations that sum up to target
// is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple ti
//mes.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// Example 4: 
//
// 
//Input: candidates = [1], target = 1
//Output: [[1]]
// 
//
// Example 5: 
//
// 
//Input: candidates = [1], target = 2
//Output: [[1,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// All elements of candidates are distinct. 
// 1 <= target <= 500 
// 
// Related Topics Array Backtracking 
// 👍 7886 👎 190


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();
            combinationSum(candidates, target, result, 0, new ArrayList<>(), 0);
            return result;
        }

        private void combinationSum(int[] candidates, int target, List<List<Integer>> result, int sum,
                                    List<Integer> visited, int index) {
            for (int i = index; i < candidates.length; i++) {
                int can = candidates[i];
                if (can + sum == target) {
                    visited.add(can);
//                    注意使用copy，不然会影响上层回溯的结果
                    result.add(new ArrayList<>(visited));
                    return;
                } else if (can + sum < target) {
                    visited.add(can);
                    combinationSum(candidates, target, result, can + sum, new ArrayList<>(visited), i);
//                    要移除原先添加的元素
                    visited.remove(visited.size() - 1);
                } else {
                    return;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}