//Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics Array Backtracking 
// 👍 8005 👎 157


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> list = Arrays.stream(nums)
                    .sorted().boxed()
                    .collect(Collectors.toCollection(LinkedList::new));

            return permute(list);
        }

        public List<List<Integer>> permute(List<Integer> list) {
            List<List<Integer>> res = new LinkedList<>();

            if (list.size() == 1) {
                List<Integer> sub = new LinkedList<>();
                sub.add(list.get(0));
                res.add(sub);
                return res;
            }

            for (int i = 0; i < list.size(); i++) {
                int n = list.remove(i);
                List<List<Integer>> subRes = permute(list);

                subRes.forEach(e -> {
                    e.add(n);
                    res.add(e);
                });

                list.add(i, n);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}