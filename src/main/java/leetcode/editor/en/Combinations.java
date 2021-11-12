//Given two integers n and k, return all possible combinations of k numbers out 
//of the range [1, n]. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics Array Backtracking 
// 👍 3174 👎 107


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> input = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
            List<List<Integer>> res = new ArrayList<>();
            backtrack(input, res, new ArrayList<>(), k, 0);
            return res;
        }

        private void backtrack(List<Integer> input, List<List<Integer>> res, List<Integer> sub, int k, int index) {
            if (sub.size() == k) {
                res.add(sub);
                return;
            }
            for (int i = index; i < input.size(); i++) {
                int val = input.get(i);
                List<Integer> next = new ArrayList<>(sub);
                next.add(val);
                backtrack(input, res, next, k, i + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}