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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WeekBi67 {
    public static void main(String[] args) {
        Solution solution = new WeekBi67().new Solution();
        System.out.println(solution.maximumDetonation(new int[][]
                {{855, 82, 158},
                        {17, 719, 430},
                        {90, 756, 164},
                        {376, 17, 340},
                        {691, 636, 152},
                        {565, 776, 5},
                        {464, 154, 271},
                        {53, 361, 162},
                        {278, 609, 82},
                        {202, 927, 219},
                        {542, 865, 377},
                        {330, 402, 270},
                        {720, 199, 10},
                        {986, 697, 443},
                        {471, 296, 69},
                        {393, 81, 404},
                        {127, 405, 177}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSubsequence(int[] nums, int k) {
            int[] numsort = Arrays.stream(nums).sorted().toArray();
            int[] tmp = Arrays.copyOfRange(numsort, numsort.length - k, numsort.length);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j : tmp) {
                map.put(j, map.getOrDefault(j, 0) + 1);
//                map.merge(j, 1, Integer::sum);
            }

            int[] res = new int[k];
            int index = k;
            for (int i = nums.length - 1; i >= 0 && index >= 0; i--) {
                if (map.containsKey(nums[i]) && map.get(nums[i]) > 0) {
                    res[--index] = nums[i];
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
            }
            return res;
        }

        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            if (security.length < 2 * time + 1) return new ArrayList<>();
            if (time == 0) return IntStream.range(0, security.length).boxed().collect(Collectors.toList());

            int[] diff = new int[security.length];
            for (int i = 1; i < security.length; i++) {
                diff[i] = security[i] - security[i - 1];
            }
            List<Integer> res = new ArrayList<>();
            for (int i = time; i < security.length - time; i++) {
                if (diff[i] <= 0 && diff[i + 1] >= 0) {
                    if (isRob(diff, i, time)) {
                        res.add(i);
                    }
                }
            }
            return res;
        }

        private boolean isRob(int[] diff, int i, int time) {
            int pre = i - time + 1;
            if (pre < 0) return false;
            int end = i + time;
            if (end >= diff.length) return false;
            while (pre <= i) {
                if (diff[pre] > 0) return false;
                pre++;
            }
            while (end > i) {
                if (diff[end] < 0) return false;
                end--;
            }
            return true;
        }

        public int maximumDetonation(int[][] bombs) {
            int[] g = IntStream.range(0, bombs.length).toArray();
            for (int i = 0; i < bombs.length - 1; i++) {
                for (int j = i + 1; j < bombs.length; j++) {
                    if (diff(bombs[i], bombs[j])) {
                        if (g[i] != i) {
                            int tmp = i;
                            while (g[tmp] != tmp) {
                                tmp = g[tmp];
                            }
                            g[j] = tmp;
                        } else if (g[j] != j) {
                            int tmp = j;
                            while (g[tmp] != tmp) {
                                tmp = g[tmp];
                            }
                            g[i] = tmp;
                        } else {
                            g[j] = i;
                        }
                    }
                }
            }
            Map<Integer, Integer> map = new HashMap<>();
            int res = 1;
            for (int i = 0; i < g.length; i++) {

                if (g[i] != i) {
                    int tmp = i;
                    while (g[tmp] != tmp) {
                        tmp = g[tmp];
                    }
                    map.put(tmp, map.getOrDefault(tmp, 1) + 1);
                    res = Math.max(res, map.get(g[i]));
                }
            }
            return res;
        }

        public boolean diff(int[] b1, int[] b2) {
            if (Math.pow(b1[0] - b2[0], 2) + Math.pow(b1[1] - b2[1], 2) <= Math.pow(b1[2], 2)
                    || Math.pow(b1[0] - b2[0], 2) + Math.pow(b1[1] - b2[1], 2) <= Math.pow(b2[2], 2)) {
                return true;
            }
            return false;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}