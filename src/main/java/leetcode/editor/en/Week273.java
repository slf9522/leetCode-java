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

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Week273 {
    public static void main(String[] args) {
        Solution solution = new Week273().new Solution();
        System.out.println(solution.recoverArray(new int[]{2, 9, 4, 6, 6, 5, 4, 5, 4, 8, 7, 10, 6, 8, 2, 3, 11, 5, 3,
                8}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] recoverArray(int[] nums) {
            int[] res = new int[nums.length / 2];
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                res = new int[nums.length / 2];
                int k2 = nums[i] - nums[0];
                if (k2 == 0 || k2 % 2 == 1) continue;

                int k = k2 / 2;

                boolean[] visit = new boolean[nums.length];
                visit[0] = true;
                visit[i] = true;
                int cnt = 0;
                res[cnt++] = nums[0] + k;

                for (int j = 1; j < nums.length; j++) {
                    if (visit[j]) continue;

                    visit[j] = true;
                    res[cnt++] = nums[j] + k;

                    int index = Arrays.binarySearch(nums, nums[j] + k2);
                    if (index < 0) {
                        break;
                    }
                    while (nums[index] == nums[j] + k2) index--;
                    index++;
                    while (visit[index] && nums[index] == nums[j] + k2) index++;
                    if (nums[index] != nums[j] + k2) break;
                    visit[index] = true;
                }

                if (cnt == nums.length / 2) break;
            }
            return res;
        }

        public long[] getDistances(int[] arr) {
            long[] res = new long[arr.length];
            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                map.putIfAbsent(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
                int start = map.get(arr[i]).get(0);
                res[start] += i - start;
            }

            for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
                List<Integer> list = e.getValue();
                int tmp = -list.size() + 2;
                for (int i = 1; i < list.size(); i++) {
                    int diff = list.get(i) - list.get(i - 1);
                    res[list.get(i)] = res[list.get(i - 1)] + (long) tmp * diff;
                    tmp += 2;
                }
            }
            return res;
        }


        public boolean isSameAfterReversals(int num) {
            if (num == 0) return true;
            return num % 10 != 0;
        }

        public int[] executeInstructions(int n, int[] startPos, String s) {
            int[] res = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                res[i] = canMove(n, startPos, s, i);
            }
            return res;
        }

        private int canMove(int n, int[] startPos, String s, int i) {
            if (i >= s.length()) return 0;

            char ci = s.charAt(i);
            int x = startPos[1], y = startPos[0];
            if (ci == 'L' && x - 1 >= 0) return 1 + canMove(n, new int[]{y, x - 1}, s, i + 1);
            if (ci == 'R' && x + 1 < n) return 1 + canMove(n, new int[]{y, x + 1}, s, i + 1);
            if (ci == 'U' && y - 1 >= 0) return 1 + canMove(n, new int[]{y - 1, x}, s, i + 1);
            if (ci == 'D' && y + 1 < n) return 1 + canMove(n, new int[]{y + 1, x}, s, i + 1);
            return 0;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}