//There are n houses evenly lined up on the street, and each house is beautifull
//y painted. You are given a 0-indexed integer array colors of length n, where col
//ors[i] represents the color of the ith house. 
//
// Return the maximum distance between two houses with different colors. 
//
// The distance between the ith and jth houses is abs(i - j), where abs(x) is th
//e absolute value of x. 
//
// 
// Example 1: 
//
// 
//Input: colors = [1,1,1,6,1,1,1]
//Output: 3
//Explanation: In the above image, color 1 is blue, and color 6 is red.
//The furthest two houses with different colors are house 0 and house 3.
//House 0 has color 1, and house 3 has color 6. The distance between them is abs
//(0 - 3) = 3.
//Note that houses 3 and 6 can also produce the optimal answer.
// 
//
// Example 2: 
//
// 
//Input: colors = [1,8,3,8,3]
//Output: 4
//Explanation: In the above image, color 1 is blue, color 8 is yellow, and color
// 3 is green.
//The furthest two houses with different colors are house 0 and house 4.
//House 0 has color 1, and house 4 has color 3. The distance between them is abs
//(0 - 4) = 4.
// 
//
// Example 3: 
//
// 
//Input: colors = [0,1]
//Output: 1
//Explanation: The furthest two houses with different colors are house 0 and hou
//se 1.
//House 0 has color 0, and house 1 has color 1. The distance between them is abs
//(0 - 1) = 1.
// 
//
// 
// Constraints: 
//
// 
// n == colors.length 
// 2 <= n <= 100 
// 0 <= colors[i] <= 100 
// Test data are generated such that at least two houses have different colors. 
//
// 
// 👍 82 👎 0


package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * 给一个list，找到不同颜色距离的最远距离
 * me：map存每个颜色第一次出现的index，list存每个颜色与<index下标所有颜色距离最小值
 * https://leetcode.com/problems/two-furthest-houses-with-different-colors/discuss/1589141/JavaC%2B%2BPython-O(n)
 * -Solution
 * 方法1:
 * head：移动tail直到颜色不同
 * tail:移动head直到颜色不同
 * 方法2:
 * 遍历列表，与首位元素比较
 */
public class TwoFurthestHousesWithDifferentColors {
    public static void main(String[] args) {
        Solution solution = new TwoFurthestHousesWithDifferentColors().new Solution();
        System.out.println(solution.maxDistance(new int[]{1, 8, 3, 8, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistance(int[] colors) {
            Map<Integer, Integer> minC = new HashMap<>();
            int[] dp = new int[colors.length];
            int res = 0;
            for (int i = 0; i < colors.length; i++) {
                int color = colors[i];
                if (!minC.containsKey(color)) minC.put(color, i);
                if (i >= 1) {
                    int maxDiff = 0;
                    for (Integer key : minC.keySet()) {
                        if (key.equals(color)) continue;
                        maxDiff = Math.max(maxDiff, Math.abs(i - minC.get(key)));
                    }
                    dp[i] = maxDiff;
                    res = Math.max(dp[i], res);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}