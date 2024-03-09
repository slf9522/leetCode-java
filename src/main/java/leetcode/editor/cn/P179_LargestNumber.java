//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 字符串 排序 👍 1245 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 最大数
 *
 * @author JX
 * @date 2024-03-07 21:47:27
 */
public class P179_LargestNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P179_LargestNumber().new Solution();
        System.out.println(solution.largestNumber(new int[]{0}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            List<String> result = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());
            Collections.sort(result, (a, b) -> (a + b).compareTo(b + a));
            Collections.reverse(result);
            int i = 0;
            for (; i < result.size(); i++) {
                if (!Objects.equals(result.get(i), "0")) {
                    break;
                }
            }
            if (i == result.size()) return "0";
            return String.join("", result.subList(i, result.size()));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}