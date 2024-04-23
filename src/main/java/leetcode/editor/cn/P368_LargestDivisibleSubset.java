//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
//
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 10⁹ 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 数学 动态规划 排序 👍 537 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 最大整除子集
 *
 * @author JX
 * @date 2024-04-03 10:28:18
 */
public class P368_LargestDivisibleSubset {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P368_LargestDivisibleSubset().new Solution();
        System.out.println(solution.largestDivisibleSubset(new int[]{4,8,10,240}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int l = nums.length;
            Map<Integer, List<Integer>> all = new HashMap<>();

            int res = 0;
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                int v = nums[i];
                List<Integer> tmp = Arrays.asList(v);
                for (Map.Entry<Integer, List<Integer>> entry : all.entrySet()) {
                    Integer pre = entry.getKey();
                    if (v % pre == 0) {
                        List<Integer> value = entry.getValue();
                        if (value.size() + 1 > tmp.size()) {
                            tmp = new ArrayList<>(value);
                            tmp.add(v);
                        }
                    }
                }
                all.put(v, tmp);

                if (res < all.get(v).size()) {
                    res = all.get(v).size();
                    result = all.get(v);
                }
            }
            return result.isEmpty() ? Arrays.asList(nums[0]) : result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}