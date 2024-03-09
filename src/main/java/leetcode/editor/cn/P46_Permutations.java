//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2826 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 全排列
 *
 * @author JX
 * @date 2024-03-08 15:20:14
 */
public class P46_Permutations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P46_Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            backTrace(set, new LinkedList<>());
            return res;
        }

        private void backTrace(Set<Integer> set, LinkedList<Integer> path) {

            if (set.isEmpty()) {
                res.add(new LinkedList<Integer>(path));
                return;
            }
            for (Integer s : set) {
                path.addLast(s);
                Set<Integer> next = new HashSet<>(set);
                next.remove(s);
                backTrace(next, path);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}