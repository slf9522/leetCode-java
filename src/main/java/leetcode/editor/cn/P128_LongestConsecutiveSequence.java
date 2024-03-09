//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2000 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 最长连续序列
 *
 * @author JX
 * @date 2024-03-09 15:32:41
 */
public class P128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P128_LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                map.putIfAbsent(n, new HashSet<>());
                if (map.containsKey(n - 1)) {
                    map.get(n - 1).add(n);
                    map.get(n).add(n - 1);
                }
                if (map.containsKey(n + 1)) {
                    map.get(n + 1).add(n);
                    map.get(n).add(n + 1);
                }
            }
            Set<Integer> keySet = map.keySet();
            Set<Integer> visited = new HashSet<>();
            int res = 1;
            for (Integer i : keySet) {
                if (visited.contains(i)) continue;
                res = Math.max(res, bfs(i, map, visited));
            }
            return res;
        }

        private int bfs(Integer i, Map<Integer, Set<Integer>> map, Set<Integer> visited) {
            Deque<Integer> dq = new LinkedList<>();
            dq.offerLast(i);
            // res和visited保持同步
            int res = 0;
            while (dq.size() != 0) {
                int size = dq.size();
                for (int j = 0; j < size; j++) {
                    int ele = dq.pollFirst();
                    if (visited.contains(ele)) continue;
                    res++;
                    visited.add(ele);
                    if (map.containsKey(ele)) {
                        dq.addAll(map.get(ele));
                    }
                }
            }
            return res;
        }


        public int longestConsecutive2(int[] nums) {
            if (nums.length == 0) return 0;
            BitSet bs = new BitSet((int) (2 * 1e9));
            for (int i = 0; i < nums.length; i++) {
                bs.set((int) (nums[i] + 1e9));
            }

            int cnt = 1;
            int res = 0;
            Iterator<Integer> iter = bs.stream().iterator();
            int pre = iter.next();
            while (iter.hasNext()) {
                int index = iter.next();
                if (index - pre == 1) {
                    cnt++;
                    res = Math.max(res, cnt);
                    pre = index;
                } else {
                    cnt = 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}