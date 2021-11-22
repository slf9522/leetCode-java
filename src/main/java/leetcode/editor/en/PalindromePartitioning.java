//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s.
//
// A palindrome string is a string that reads the same backward as forward. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 4743 👎 147


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        System.out.println(solution.partition2("cbbbcc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<String> input = Arrays.asList(s.split(""));
            List<List<String>> res = new ArrayList<>();
            res.add(input);
            for (int i = 0; i < input.size(); i++) {
                backTack(input, res, i, i + 1);
                backTack(input, res, i, i + 2);
            }
            return res;
        }

        /**
         * 递归
         * @param input 单元素的输入
         * @param res 结果
         * @param left 回文的左侧
         * @param right 回文的右侧
         */
        private void backTack(List<String> input, List<List<String>> res, int left, int right) {
            List<String> next = new ArrayList<>();
            if (left >= 0 && right < input.size() && input.get(left).equals(input.get(right))) {
                next.addAll(input.subList(0, left));
                next.add(String.join("", input.subList(left, right + 1)));
//                next.addAll(input.subList(right + 1, input.size()));
                if (input.subList(right + 1, input.size()).size() > 0) {
                    List<List<String>> subRes = partition(String.join("", input.subList(right + 1, input.size())));
                    subRes.stream().forEach(l -> {
                        List<String> nn = new ArrayList<>(next);
                        nn.addAll(l);
                        res.add(nn);
                    });
                } else {
                    res.add(next);
                }
                backTack(input, res, left - 1, right + 1);

            }
        }

        public List<List<String>> partition2(String s) {
            List<List<String>> list = new ArrayList<>();
            backtrack(list, new ArrayList<>(), s, 0);
            return list;
        }

        /**
         * @param list     返回结果
         * @param tempList 一次backtrck的结果
         * @param s        输入字符串
         * @param start    本次开始递归的起点
         */
        public void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
            if (start == s.length())
                list.add(new ArrayList<>(tempList));
            else {
                for (int i = start; i < s.length(); i++) {
                    if (isPalindrome(s, start, i)) {
                        tempList.add(s.substring(start, i + 1));
                        backtrack(list, tempList, s, i + 1);
                        tempList.remove(tempList.size() - 1);
                    }
                }
            }
        }

        public boolean isPalindrome(String s, int low, int high) {
            while (low < high)
                if (s.charAt(low++) != s.charAt(high--)) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}