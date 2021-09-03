//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// How many possible unique paths are there? 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 7
//Output: 28
// 
//
// Example 2: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-righ
//t corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
// 
//
// Example 3: 
//
// 
//Input: m = 7, n = 3
//Output: 28
// 
//
// Example 4: 
//
// 
//Input: m = 3, n = 3
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// It's guaranteed that the answer will be less than or equal to 2 * 109. 
// 
// Related Topics Math Dynamic Programming Combinatorics 
// 👍 6189 👎 258


package leetcode.editor.en;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] road = new int[n];
            Arrays.fill(road, 1);

            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j >= 1) {
                        road[j] = road[j] + road[j - 1];
                    }
                }
            }

            return road[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}