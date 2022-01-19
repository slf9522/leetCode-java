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
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Week276 {
    public static void main(String[] args) {
        Solution solution = new Week276().new Solution();
//        System.out.println(solution.checkValid(new int[][]{{1, 2, 3}, {3, 1, 2}, {2, 3, 1}}));
        System.out.println(solution.minSwaps(new int[]{0, 1, 1, 0, 1, 1}));
//        System.out.println(solution.wordCount(new String[]{"g", "vf", "ylpuk", "nyf", "gdj", "j", "fyqzg", "sizec"},
//                new String[]{"r", "am", "jg", "umhjo", "fov", "lujy", "b", "uz", "y"}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValid(int[][] matrix) {
            Set<Integer> set = IntStream.range(1, matrix.length + 1).boxed().collect(Collectors.toSet());
            for (int i = 0; i < matrix.length; i++) {
                Set<Integer> tmp = new HashSet<>();
                for (int j = 0; j < matrix[0].length; j++) {
                    tmp.add(matrix[i][j]);
                }
                if (!tmp.equals(set)) return false;
            }

            for (int i = 0; i < matrix.length; i++) {
                Set<Integer> tmp = new HashSet<>();
                for (int j = 0; j < matrix[0].length; j++) {
                    tmp.add(matrix[j][i]);
                }
                if (!tmp.equals(set)) return false;
            }

            return true;
        }

        public int minSwaps(int[] nums) {
            int sum = 0;
            int[] acc = new int[nums.length];
            acc[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                acc[i] = acc[i - 1] + nums[i];
                if (nums[i] == 1) sum++;
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int tmp;
                if (i + sum >= nums.length) {
                    int left = sum - (nums.length - i);
                    tmp = acc[nums.length - 1] + acc[left - 1] - acc[i];
                } else {
                    tmp = acc[i + sum - 1] - acc[i];
                }
                res = Math.min(res, sum - tmp);
            }
            return res;
        }

        public int wordCount(String[] startWords, String[] targetWords) {
            Map<Integer, List<BitSet>> map = new HashMap<>();
            for (int i = 0; i < startWords.length; i++) {

                BitSet bs = new BitSet(26);
                for (int j = 0; j < startWords[i].length(); j++) {
                    bs.set(startWords[i].charAt(j) - 'a');
                }
                map.putIfAbsent(startWords[i].length(), new ArrayList<>());
                map.get(startWords[i].length()).add(bs);
            }

            int res = 0;
            for (int i = 0; i < targetWords.length; i++) {
                List<BitSet> sl = map.get(targetWords[i].length() - 1);
                if (sl == null) continue;

                BitSet bs = new BitSet(26);
                for (int j = 0; j < targetWords[i].length(); j++) {
                    bs.set(targetWords[i].charAt(j) - 'a');
                }

                for (int j = 0; j < sl.size(); j++) {
                    BitSet bsj = (BitSet) sl.get(j).clone();
                    bsj.xor(bs);
                    if (bsj.cardinality() == 1) {
                        res++;
                        break;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}