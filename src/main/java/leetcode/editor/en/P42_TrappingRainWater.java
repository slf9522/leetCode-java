//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 30644 👎 463


package leetcode.editor.en;

/**
 * Trapping Rain Water
 *
 * @author JX
 * @date 2024-02-28 09:56:22
 */
public class P42_TrappingRainWater {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P42_TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{4,2,0,3,2,5}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int l = height.length;
            int[] left = new int[l];
            int[] right = new int[l];

            left[0] = height[0];
            for (int i = 1; i < l; i++) {
                left[i] = Math.max(left[i - 1], height[i]);
            }

            right[l - 1] = height[l - 1];
            for (int i = l - 2; i >= 0; i--) {
                right[i] = Math.max(right[i + 1], height[i]);
            }

            int res = 0;
            for (int i = 0; i < l; i++) {
                res += Math.min(left[i], right[i]) - height[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
