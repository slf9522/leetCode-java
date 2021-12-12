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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Week271 {
    public static void main(String[] args) {
        Solution solution = new Week271().new Solution();
        System.out.println(solution.maxTotalFruits(new int[][]{
                        {20000, 1000}},
                0, 20000));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPoints(String rings) {
            int cnt = 0;
            Map<Integer, Set<Character>> map = new HashMap<>();
            for (int i = 1; i < rings.length(); i = i + 2) {
                int j = rings.charAt(i);
                Character ci = rings.charAt(i - 1);
                if (map.containsKey(j) && map.get(j).contains(ci)) {
                    continue;
                } else {
                    if (!map.containsKey(j)) map.put(j, new HashSet<>());
                    map.get(j).add(ci);
                }
                if (map.get(j).size() == 3) cnt++;
            }
            return cnt;
        }

        public long subArrayRanges(int[] nums) {
            long res = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                int ni = nums[i];
                int min = nums[i];
                int max = nums[i];
                for (int j = 1; j < nums.length; j++) {
                    int nj = nums[j];
                    min = Math.min(min, nj);
                    max = Math.max(max, nj);
                    res += max - min;
                }
            }
            return res;
        }

        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int res = 0;
            int i = 0;
            int j = plants.length - 1;
            int ca = capacityA, cb = capacityB;
            while (i < j) {
                if (plants[i] <= ca) {
                    ca -= plants[i];
                    i++;
                } else if (plants[i] > ca) {
                    ca = capacityA - plants[i];
                    i++;
                    res++;
                }

                if (plants[j] <= cb) {
                    cb -= plants[j];
                    j--;
                } else if (plants[j] > cb) {
                    cb = capacityB - plants[j];
                    j--;
                    res++;
                }
            }

            if (i == j) {
                if (ca < cb) {
                    if (plants[i] > cb) res++;
                } else {
                    if (plants[i] > ca) res++;
                }
            }
            return res;
        }

        public int maxTotalFruits(int[][] fruits, int startPos, int k) {
            List<int[]> list = Arrays.stream(fruits).map(e -> Arrays.copyOf(e, 2)).collect(Collectors.toList());
            List<Integer> p = Arrays.stream(fruits).map(e -> e[0]).collect(Collectors.toList());
            return maxTotalFruits(list, startPos, k, p);
        }

        public int maxTotalFruits(List<int[]> fruits, int startPos, int k, List<Integer> p) {

            int res = 0;
            if (k < 0) return 0;

            int index = Collections.binarySearch(p, startPos);
            if (index >= 0) {
                int[] tmp = fruits.get(index);
                res += tmp[1];

                int res1 = 0, res2 = 0;
                if (index + 1 < p.size()) {
                    int ss = p.get(index + 1);
                    int kk = k - (p.get(index + 1) - startPos);
                    fruits.remove(index);
                    p.remove(index);
                    res1 = maxTotalFruits(fruits, ss, kk, p);
                    fruits.add(index, tmp);
                    p.add(startPos);
                }
                if (index - 1 >= 0) {
                    int ss = p.get(index - 1);
                    int kk = k - (startPos - p.get(index - 1));
                    fruits.remove(index);
                    p.remove(index);
                    res2 = maxTotalFruits(fruits, ss, kk, p);
                    fruits.add(index, tmp);
                    p.add(startPos);
                }
                res = res + Math.max(res1, res2);
            } else {
                index = -index - 1;
                if (startPos + k < p.get(0) || startPos - k > p.get(p.size() - 1)) {

                } else {
                    if (index == 0) res = res + maxTotalFruits(fruits, p.get(index), k - (p.get(index) - startPos), p);
                    else if (index == p.size())
                        res = res + maxTotalFruits(fruits, p.get(index - 1), k - (startPos - p.get(index - 1)), p);
                    else res = res + Math.max(maxTotalFruits(fruits, p.get(index), k - (p.get(index) - startPos), p),
                                maxTotalFruits(fruits, p.get(index - 1), k - (startPos - p.get(index - 1)), p));
                }
            }
            return res;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}