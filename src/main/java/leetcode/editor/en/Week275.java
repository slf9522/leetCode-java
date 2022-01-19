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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Week275 {
    public static void main(String[] args) {
        Solution solution = new Week275().new Solution();
//        solution.pairSum(new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1)))));
//        System.out.println(solution.longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}));
        System.out.println(solution.possibleToStamp(new int[][]{
                {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}
        }, 4, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String capitalizeTitle(String title) {
            String[] array = title.split(" ");

            String[] res = new String[title.length()];
            for (int i = 0; i < array.length; i++) {
                if (array[i].length() > 2) {
                    res[i] = array[i].substring(0, 1).toUpperCase() + array[i].substring(1).toLowerCase();
                } else {
                    res[i] = array[i].toLowerCase();
                }
            }
            return String.join(" ", res);
        }

        public int pairSum(ListNode head) {
            ListNode h = head;
            int n = 0;
            while (h != null && h.next != null) {
                h = h.next.next;
                n += 2;
            }
            int half = n / 2;
            LinkedList<ListNode> stack = new LinkedList<>();
            h = head;
            while (half > 0) {
                stack.addLast(h);
                h = h.next;
                half--;
            }

            int res = 0;
            while (stack.size() > 0) {
                res = Math.max(res, stack.pollLast().val + h.val);
                h = h.next;
            }
            return res;
        }

        public int longestPalindrome(String[] words) {
            Map<String, Integer[]> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String si = words[i];
                String is = new StringBuilder(si).reverse().toString();
                if (map.containsKey(si)) {
                    map.get(si)[0] += 1;
                } else if (map.containsKey(is)) {
                    map.get(is)[1] += 1;
                } else {
                    map.put(si, new Integer[]{1, 0});
                }
            }
            int same = 0;
            int pali = 0;
            for (Map.Entry<String, Integer[]> entry : map.entrySet()) {
                String key = entry.getKey();
                int left = entry.getValue()[0], right = entry.getValue()[1];
                if (key.charAt(0) == key.charAt(1)) {
                    same += left % 2;
                    pali += left / 2;
                }
                pali += Math.min(left, right);
            }
            if (same == 0) {
                return pali * 4;
            } else {
                return 2 + pali * 4;
            }
        }

        public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        list.add(new Pair(i, j));
                    }
                }
            }
            paint(grid, 0, 0, stampHeight, stampWidth, list);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                }
            }
            return true;
        }

        private void paint(int[][] grid, int x, int y, int stampHeight, int stampWidth, List<Pair> block) {
            if (x == grid.length - stampHeight || y == grid[0].length - stampWidth) return;

            int index = Collections.binarySearch(block, new Pair(x, y), (o1, o2) -> o1.x == o2.x ? o1.y - o2.y :
                    o1.x - o2.x);
            int index2 = Collections.binarySearch(block, new Pair(x + stampHeight, y + stampWidth),
                    (o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x);


            index = index < 0 ? -index - 1 : index;
            index2 = index2 < 0 ? -index2 - 1 : index2;

//            if (index == index2 && block.get(index).x) {
//                for (int i = x; i < x + stampHeight; i++) {
//                    for (int j = y; j < y + stampWidth; j++) {
//                        grid[x][y] += 1;
//                    }
//                }
//            }

            paint(grid, x + 1, y, stampHeight, stampWidth, block);
            paint(grid, x, y + 1, stampHeight, stampWidth, block);
            paint(grid, x + 1, y + 1, stampHeight, stampWidth, block);
        }

        class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}