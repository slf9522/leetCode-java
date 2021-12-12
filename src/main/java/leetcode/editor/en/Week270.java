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
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Week270 {
    public static void main(String[] args) {
        Solution solution = new Week270().new Solution();
        System.out.println(solution.validArrangement(new int[][]
                {{1, 3}, {3, 2}, {2, 1}}));
//        [5,1,2,3,null,6,4]
//3
//6
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1, new TreeNode(3), null);
//        root.right = new TreeNode(2, new TreeNode(6), new TreeNode(4));
//        System.out.println(solution.getDirections(root, 3, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findEvenNumbers(int[] digits) {
            Set<Integer> res = new HashSet<>();
            for (int i = 0; i <= digits.length - 3; i++) {
                for (int j = i + 1; j <= digits.length - 2; j++) {
                    for (int k = j + 1; k <= digits.length - 1; k++) {
                        res.addAll(getEven(digits[i], digits[j], digits[k]));
                    }
                }
            }

            int[] result = new int[res.size()];
            List<Integer> list = res.stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        private List<Integer> getEven(int a, int b, int c) {
            List<Integer> res = new ArrayList<>();
            if (a != 0) {
                if (b % 2 == 0) res.add(a * 100 + c * 10 + b);
                if (c % 2 == 0) res.add(a * 100 + b * 10 + c);
            }
            if (b != 0) {
                if (a % 2 == 0) res.add(b * 100 + c * 10 + a);
                if (c % 2 == 0) res.add(b * 100 + a * 10 + c);
            }
            if (c != 0) {
                if (b % 2 == 0) res.add(c * 100 + a * 10 + b);
                if (a % 2 == 0) res.add(c * 100 + b * 10 + a);
            }
            return res;
        }

        public String getDirections(TreeNode root, int startValue, int destValue) {
            String res = "";
            String s = search(root, startValue).toString();
            String d = search(root, destValue).toString();
            // 共同父节点
            int i = 0;
            while (i < s.length() && i < d.length() && s.charAt(i) == d.charAt(i)) {
                i++;
            }

            for (int j = i; j < s.length() - 1; j++) {
                res += "U";
            }
            res += d.substring(i, d.length() - 1);
            return res;
        }

        private StringBuilder search(TreeNode root, int val) {
            if (root.val == val) {
                return new StringBuilder(";");
            }

            if (root.left != null) {
                StringBuilder l = search(root.left, val);
                if (l.length() > 0) {
                    l.insert(0, "L");
                    return l;
                }
            }
            if (root.right != null) {
                StringBuilder l = search(root.right, val);
                if (l.length() > 0) {
                    l.insert(0, "R");
                    return l;
                }
            }
            return new StringBuilder();
        }

        public int[][] validArrangement(int[][] pairs) {
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> number = new HashSet<>();
            for (int i = 0; i < pairs.length; i++) {
                int[] pair = pairs[i];
                if (graph.containsKey(pair[0])) {
                    graph.get(pair[0]).add(pair[1]);
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(pair[1]);
                    graph.put(pair[0], tmp);
                }
                number.add(pair[0]);
                number.add(pair[1]);
            }
            List<Integer> result = new ArrayList<>();
            for (Integer i : graph.keySet()) {
                dfsG(graph, i, new ArrayList<>(number), result);
                if (result.size() == number.size()) break;
            }

            int[][] res = new int[number.size() - 1][2];
            int i = 0;
            for (; i < result.size() - 1; i++) {
                res[i] = new int[]{result.get(i), result.get(i + 1)};
            }
            return res;
        }

        private void dfsG(HashMap<Integer, List<Integer>> graph, Integer i, List<Integer> set, List<Integer> res) {

            if (set.size() == 1 && i == set.get(0)) {
                res.add(set.get(0));
                set.remove(set.get(0));
                return;
            }

            if (!graph.containsKey(i)) return;
            List<Integer> gi = graph.get(i);
            for (int j = 0; j < gi.size(); j++) {
                if (!set.contains(gi.get(j))) continue;
                set.remove(i);
                res.add(i);
                dfsG(graph, gi.get(j), set, res);
                if (set.size() != 0) {
                    set.add(i);
                    res.remove(i);
                } else {
                    return;
                }
            }
            return;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        int cnt = 0;
        ListNode h = head;
        while (h != null) {
            h = h.next;
            cnt++;
        }
        int mid = cnt / 2 - 1;
        ListNode pre = new ListNode(0, head);
        cnt = -1;
        h = pre;
        while (cnt != mid) {
            h = h.next;
            cnt++;
        }

        h.next = h.next.next;
        return pre.next;
    }


//leetcode submit region end(Prohibit modification and deletion)

}