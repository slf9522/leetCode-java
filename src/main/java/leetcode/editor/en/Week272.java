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
import java.util.List;
import java.util.TreeMap;

public class Week272 {
    public static void main(String[] args) {
        Solution solution = new Week272().new Solution();
        System.out.println(solution.kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String firstPalindrome(String[] words) {
            for (int i = 0; i < words.length; i++) {
                if (isPalin(words[i])) return words[i];
            }
            return "";
        }

        private boolean isPalin(String word) {
            int i = 0, j = word.length() - 1;
            while (i <= j) {
                if (word.charAt(i) != word.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }

        public String addSpaces(String s, int[] spaces) {
            StringBuilder sb = new StringBuilder();
            int begin = 0;
            for (int i = 0; i < spaces.length; i++) {
                if (spaces[i] == 0) {
                    sb.append(' ');
                    continue;
                }
                sb.append(s, begin, spaces[i]);
                begin = spaces[i];
                sb.append(' ');
            }
            sb.append(s, begin, s.length());
            return sb.toString();
        }

        public long getDescentPeriods(int[] prices) {
            long res = 1;
            long[] a = new long[prices.length];
            Arrays.fill(a, 1);
            for (int i = prices.length - 2; i >= 0; i--) {
                if (prices[i] - prices[i + 1] == 1) {
                    a[i] = a[i + 1] + 1;
                }
                res += a[i];
            }
            return res;
        }

        public int kIncreasing(int[] arr, int k) {
            int res = 0;
            for (int i = 0; i < k; i++) {
                List<Integer> sub = new ArrayList<>();
                boolean flag = true;
                for (int j = i; j < arr.length; ) {
                    sub.add(arr[j]);
                    j += k;
                    if (j < arr.length && arr[j - k] > arr[j]) flag = false;
                }
                if (!flag) res += sub.size() - lengthOfLIS(sub);
            }
            return res;
        }

        public int lengthOfLIS(List<Integer> nums) {
            int[] dp = new int[nums.size()];
            Arrays.fill(dp, 1);
            // nums[i], dp[i]
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int res = 1;
            for (int i = 0; i < nums.size(); i++) {
                int ni = nums.get(i);
                int max = map.headMap(ni, true).values().stream().max(Integer::compareTo).orElse(0);
                dp[i] = Math.max(dp[i], max + 1);
                map.put(ni, map.getOrDefault(ni, 1) < dp[i] ? dp[i] : map.getOrDefault(ni, 1));
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}