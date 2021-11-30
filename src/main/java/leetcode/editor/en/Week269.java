//Given two string arrays words1 and words2, return the number of strings that a
//ppear exactly once in each of the two arrays. 
//
// 
// Example 1: 
//
// 
//Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","le
//etcode","is"]
//Output: 2
//Explanation:
//- "leetcode" appears exactly once in each of the two arrays. We count this str
//ing.
//- "amazing" appears exactly once in each of the two arrays. We count this stri
//ng.
//- "is" appears in each of the two arrays, but there are 2 occurrences of it in
// words1. We do not count this string.
//- "as" appears once in words1, but does not appear in words2. We do not count 
//this string.
//Thus, there are 2 strings that appear exactly once in each of the two arrays.
// 
//
// Example 2: 
//
// 
//Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
//Output: 0
//Explanation: There are no strings that appear in each of the two arrays.
// 
//
// Example 3: 
//
// 
//Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
//Output: 1
//Explanation: The only string that appears exactly once in each of the two arra
//ys is "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= words1.length, words2.length <= 1000 
// 1 <= words1[i].length, words2[j].length <= 30 
// words1[i] and words2[j] consists only of lowercase English letters. 
// 
// 👍 39 👎 0


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Week269 {
    public static void main(String[] args) {
        Solution solution = new Week269().new Solution();
        System.out.println(solution.findAllPeople(5, new int[][]
                        {{3, 4, 2}, {1, 2, 1}, {2, 3, 1}}
                , 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> targetIndices(int[] nums, int target) {
            List<Integer> res = new ArrayList<>();
            Arrays.sort(nums);
            // 存在重复元素使，index不确定
            int index = Arrays.binarySearch(nums, target);
            if (index < 0) return res;
            int tmp = index + 1;
            while (index >= 0) {
                if (nums[index] == target) {
                    res.add(0, index--);
                } else {
                    break;
                }
            }
            while (tmp < nums.length) {
                if (nums[tmp] == target) {
                    res.add(tmp++);
                } else {
                    break;
                }
            }
            return res;
        }

        public int[] getAverages(int[] nums, int k) {
            int[] res = new int[nums.length];
            Long sum = 0L;
            Long pre = 0L;
            for (int i = 0; i < nums.length; i++) {
                if (i < k || i + k > nums.length - 1) {
                    res[i] = -1;
                    continue;
                }
                if (i - k == 0) {
                    int j = 0;
                    while (j <= i + k) {
                        sum += nums[j++];
                    }
                    // 任何计算小心溢出
                    res[i] = (int) (sum / (2 * k + 1));
                    pre = sum;
                } else {
                    Long tmp = (pre - nums[i - 1 - k] + nums[i + k]);
                    res[i] = (int) (tmp / (2 * k + 1));
                    pre = tmp;
                }
            }
            return res;
        }

        public int minimumDeletions(int[] nums) {
            int min = nums[0], max = nums[0];
            int i = 0, j = 0;
            for (int k = 0; k < nums.length; k++) {
                int num = nums[k];
                if (num < min) {
                    min = num;
                    i = k;
                }
                if (num > max) {
                    max = num;
                    j = k;
                }
            }
            return Math.min(
                    Math.max(i, j) + 1,
                    Math.min(nums.length - Math.min(i, j),
                            Math.min(i, j) + 1 + nums.length - Math.max(i, j))
            );
        }

        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            Set<Integer> set = new HashSet<>();
            set.add(0);
            set.add(firstPerson);
            Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

            for (int i = 0; i < meetings.length; ) {
                if (set.size() == n) return new ArrayList<>(set);
                HashMap<Integer, List<Integer>> map = new HashMap<>();
                int j = i;
                while (j < meetings.length && meetings[j][2] == meetings[i][2]) {
                    int[] m = meetings[j];
                    map.putIfAbsent(m[0], new ArrayList<>());
                    map.putIfAbsent(m[1], new ArrayList<>());
                    map.get(m[0]).add(m[1]);
                    map.get(m[1]).add(m[0]);
                    j++;
                }

                Set<Integer> tmp = new HashSet<>(map.keySet());
                tmp.retainAll(set);
                for (Integer start : tmp) {
                    dfs(start, map, set);
                }
                i = j;
            }

            return new ArrayList<>(set);
        }

        private void dfs(Integer start, HashMap<Integer, List<Integer>> map, Set<Integer> set) {
            List<Integer> path = map.get(start);
            for (int i = 0; i < path.size(); i++) {
                if (set.contains(path.get(i))) continue;
                set.add(path.get(i));
                dfs(path.get(i), map, set);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}