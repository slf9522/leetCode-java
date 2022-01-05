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
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Week274 {
    public static void main(String[] args) {
        Solution solution = new Week274().new Solution();
//        mass = 5, asteroids = [4,9,23,4]
//        System.out.println(solution.maximumInvitations(new int[]{1, 0, 0, 2, 1, 4, 7, 8, 9, 6, 7, 10, 8}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkString(String s) {
            boolean meet = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'b') meet = true;
                if (meet && s.charAt(i) == 'a') return false;
            }
            return true;
        }

        public int numberOfBeams(String[] bank) {
            int[] p = new int[bank.length];
            for (int i = 0; i < bank.length; i++) {
                int cnt = (int) Arrays.stream(bank[i].split("")).filter("1"::equals).count();
                p[i] = cnt;
            }

            int res = 0;
            int pre = p[0];
            int i = 1;
            while (i < p.length) {
                if (p[i] != 0) {
                    res += pre * p[i];
                    pre = p[i];
                }
                i++;
            }
            return res;
        }

        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);
            int i = 0;
            if (asteroids[i] > mass) return false;

            Deque<Integer> deque = new ArrayDeque<>();
            deque.addLast(asteroids[0]);

            while (i < asteroids.length && deque.size() > 0) {
                if (mass >= asteroids[i]) {
                    deque.addLast(asteroids[i]);
                    i++;
                } else {
                    mass += deque.removeLast();
                }
            }
            return i == asteroids.length;
        }

//        public int maximumInvitations(int[] favorite) {
//            List<List<Integer>> pair = new ArrayList<>();
//            List<List<Integer>> graph = new ArrayList<>();
//
//            for (int i = 0; i < favorite.length; i++) {
//                graph.add(i, new ArrayList<>());
//            }
//
//            for (int i = 0; i < favorite.length; i++) {
//                if (i < favorite[i] && i == favorite[favorite[i]]) {
//                    pair.add(Arrays.asList(i, favorite[i]));
//                }
//                graph.get(favorite[i]).add(i);
//            }
//
//            boolean[] visited = new boolean[favorite.length];
//
//            int maxPair = 0;
//            for (int i = 0; i < pair.size(); i++) {
//                List<Integer> p = pair.get(i);
//                maxPair += dfs(p.get(0), graph, visited) + dfs(p.get(1), graph, visited);
//            }
//
//            int[] round = new int[favorite.length];
//            int roundCnt = 0;
//            int maxRount = 0;
//            for (int i = 0; i < favorite.length; i++) {
//                if (visited[i]) continue;
//                if (round[i] != 0) continue;
//
//                roundCnt++;
//                round[i] = roundCnt;
//                int cnt = 0;
//                while (round[i] != roundCnt) {
//
//                }
//            }
//
//        }
//
//        private int dfs(Integer i, List<List<Integer>> graph, boolean[] visited) {
//            int max = 1;
//            visited[i] = true;
//            for (int next : graph.get(i)) {
//                visited[next] = true;
//                max = Math.max(max, 1 + dfs(next, graph, visited));
//            }
//            return max;
//        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}