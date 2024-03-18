//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1799 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素
 *
 * @author JX
 * @date 2024-03-18 08:09:56
 */
public class P347_TopKFrequentElements {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P347_TopKFrequentElements().new Solution();
//        System.out.println(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        System.out.println(solution.topKFrequent(new int[]{1, 2}, 2));

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Arrays.sort(nums);
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int l = nums.length;
            int i = 0, j = 0;
            for (; i < l && j < l; ) {
                while (j < l && nums[j] == nums[i]) j++;
                Node n = new Node(nums[i], j - i);
                if (pq.size() == k) {
                    if (pq.peek().freq < j - i) {
                        pq.poll();
                        pq.offer(n);
                    }
                } else {
                    pq.offer(n);
                }
                i = j;

            }

            int[] res = new int[k];
            for (int m = k - 1; m >= 0; m--) {
                res[m] = pq.poll().v;
            }
            return res;
        }

        class Node implements Comparable<Node> {
            int v;
            int freq;

            public Node(int v, int freq) {
                this.v = v;
                this.freq = freq;
            }


            @Override
            public int compareTo(Node o) {
                return this.freq - o.freq;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}