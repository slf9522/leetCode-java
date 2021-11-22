//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics Math Dynamic Programming Memoization 
// 👍 9035 👎 271


package leetcode.editor.en;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 0:preStep = 1
        // 1:curStep = 1
        // 2:2
        // 3:3
        public int climbStairs(int n) {
            int preStep = 1, curStep = 1, cur = 1;
            if (n == 1) return preStep;
            // 实际上计算的是cur + 1，所以条件是<
            while (cur < n) {
                int tmp = curStep;
                curStep = preStep + curStep;
                preStep = tmp;
                cur++;
            }
            return curStep;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}