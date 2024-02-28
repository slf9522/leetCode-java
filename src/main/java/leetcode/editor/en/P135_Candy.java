//There are n children standing in a line. Each child is assigned a rating 
//value given in the integer array ratings. 
//
// You are giving candies to these children subjected to the following 
//requirements: 
//
// 
// Each child must have at least one candy. 
// Children with a higher rating get more candies than their neighbors. 
// 
//
// Return the minimum number of candies you need to have to distribute the 
//candies to the children. 
//
// 
// Example 1: 
//
// 
//Input: ratings = [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 
//2 candies respectively.
// 
//
// Example 2: 
//
// 
//Input: ratings = [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 
//1 candies respectively.
//The third child gets 1 candy because it satisfies the above two conditions.
// 
//
// 
// Constraints: 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
//
// Related Topics Array Greedy 👍 7511 👎 612


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Candy
 *
 * @author JX
 * @date 2024-02-23 15:41:24
 */
public class P135_Candy {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P135_Candy().new Solution();
        System.out.println(solution.candy(new int[]{1, 2, 2}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            // 从左遍历一遍，再从右遍历一遍
            int l = ratings.length;
            int[] left = new int[l];

            left[0] = 1;
            for (int i = 1; i < l; i++) {
                int r = ratings[i];
                if (r > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                }
            }

            int[] right = new int[l];
            right[l - 1] = 1;
            for (int i = l - 2; i >= 0; i--) {
                int r = ratings[i];
                if (r > ratings[i + 1]) {
                    right[i] = right[i + 1] + 1;
                }
            }
            int res = 0;
            for (int i = 0; i < l; i++) {
                res += Math.max(left[i], right[i]);
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
