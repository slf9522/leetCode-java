//给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。 
//
// 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。 
//
// 返回数组能分成的最多块数量。 
//
// 
//
// 示例 1: 
//
// 
//输入: arr = [4,3,2,1,0]
//输出: 1
//解释:
//将数组分成2块或者更多块，都无法得到所需的结果。
//例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
// 
//
// 示例 2: 
//
// 
//输入: arr = [1,0,2,3,4]
//输出: 4
//解释:
//我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
//然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
//对每个块单独排序后，结果为 [0, 1], [2], [3], [4]
// 
//
// 
//
// 提示: 
//
// 
// n == arr.length 
// 1 <= n <= 10 
// 0 <= arr[i] < n 
// arr 中每个元素都 不同 
// 
//
// Related Topics 栈 贪心 数组 排序 单调栈 👍 404 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 最多能完成排序的块
 *
 * @author JX
 * @date 2024-03-25 13:26:43
 */
public class P769_MaxChunksToMakeSorted {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P769_MaxChunksToMakeSorted().new Solution();
        System.out.println(solution.maxChunksToSorted(new int[]{1,0,2,3,4}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxChunksToSorted(int[] arr) {

            int start = 0;
            int max = arr[0];
            int min = arr[0];
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                int v = arr[i];
                max = Math.max(max, v);
                min = Math.min(min, v);
                if (min == start && max == i) {
                    res.add(i);
                    start = i + 1;
                    max = start;
                    min = Integer.MAX_VALUE;
                }

            }
            return res.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}