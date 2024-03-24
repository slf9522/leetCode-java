//给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。 
//
// 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个
//元素是 nums[(i - 1 + n) % n] 。 
//
// 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不
//存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 
//
// Related Topics 队列 数组 分治 动态规划 单调队列 👍 682 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 环形子数组的最大和
 *
 * @author JX
 * @date 2024-03-24 13:13:00
 */
public class P918_MaximumSumCircularSubarray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P918_MaximumSumCircularSubarray().new Solution();
        System.out.println(solution.maxSubarraySumCircular(new int[]{3,-2,2,-3}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubarraySumCircular(int[] nums) {
            int maxS = Integer.MIN_VALUE;
            int maxF = maxS;
            int minS = 0;
            int minF = 0;
            int sum = 0;
            for (int n : nums) {
                maxS = Math.max(maxS, 0) + n;
                maxF = Math.max(maxF, maxS);

                minS = Math.min(minS, 0) + n;
                minF = Math.min(minF, minS);
                sum += n;
            }
            if (minF == sum) {
                return maxF;
            } else {
                return Math.max(maxF, sum - minF);
            }
        }

        public int maxSubarraySumCircular2(int[] nums) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            });
            int l = nums.length;
            int[] tmp = new int[l * 2];
            for (int i = 0; i < nums.length * 2; i++) {
                tmp[i] = nums[i % l];
            }
            int[] sum = new int[2 * l];
            sum[0] = tmp[0];
            pq.add(new int[]{0, -1});
            pq.add(new int[]{tmp[0], 0});
            int res = tmp[0];
            for (int i = 1; i < l * 2; i++) {
                sum[i] = sum[i - 1] + tmp[i];
                while (!pq.isEmpty() && i - pq.peek()[1] > l) {
                    pq.poll();
                }
                if (!pq.isEmpty()) {
                    res = Math.max(res, sum[i] - pq.peek()[0]);
                }
                pq.offer(new int[]{sum[i], i});
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}