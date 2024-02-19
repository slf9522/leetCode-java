//You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] 
//represents the width and the height of an envelope. 
//
// One envelope can fit into another if and only if both the width and height 
//of one envelope are greater than the other envelope's width and height. 
//
// Return the maximum number of envelopes you can Russian doll (i.e., put one 
//inside the other). 
//
// Note: You cannot rotate an envelope. 
//
// 
// Example 1: 
//
// 
//Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] 
//=> [5,4] => [6,7]).
// 
//
// Example 2: 
//
// 
//Input: envelopes = [[1,1],[1,1],[1,1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics Array Binary Search Dynamic Programming Sorting 👍 5835 👎 140
//


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.max;

/**
 * Russian Doll Envelopes
 *
 * @author JX
 * @date 2024-02-14 13:31:43
 */
public class P354_RussianDollEnvelopes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P354_RussianDollEnvelopes().new Solution();
    }

    //力扣代码	`
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
			int res = 1;
			int[] dp = new int[envelopes.length];
			Arrays.fill(dp, 1);

			// sort before 二维变一维
			Arrays.sort(envelopes, (a,b) -> a[0]- b[0] == 0?b[1]-a[1]:a[0]-b[0]);
			for (int i = 0; i < envelopes.length; i++) {
				for (int j = i-1; j >=0 ; j--) {
					if(envelopes[i][1]>envelopes[j][1]){
						dp[i] = Math.max(dp[i], dp[j] + 1);
						res = Math.max(res, dp[i]);
					}
				}
			}

			return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
