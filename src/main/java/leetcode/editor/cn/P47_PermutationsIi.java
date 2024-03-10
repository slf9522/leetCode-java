//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1547 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 *
 * @author JX
 * @date 2024-03-10 15:19:00
 */
public class P47_PermutationsIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P47_PermutationsIi().new Solution();
        System.out.println(solution.permuteUnique(new int[]{1,1,2}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            backTrace(nums, new LinkedList<>(), new boolean[nums.length], 0);
            return res;
        }

        private void backTrace(int[] nums, LinkedList<Integer> path, boolean[] visited, int cnt) {
            if (cnt == nums.length) {
                res.add(new LinkedList<>(path));
            }

            for (int i = 0; i < nums.length; i++) {
                if (!visited[i] && notSame(nums, i, visited)) {
                    path.addLast(nums[i]);
                    visited[i] = true;
                    backTrace(nums, path, visited, cnt + 1);
                    path.removeLast();
                    visited[i] = false;
                }
            }

        }

        private boolean notSame(int[] nums, int i, boolean[] visited) {
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                if (visited[i + 1]) return false;
                i++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}