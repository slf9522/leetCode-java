//Given an integer numRows, return the first numRows of Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly abov
//e it as shown: 
//
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics Array Dynamic Programming 
// 👍 4163 👎 176


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        System.out.println(solution.generate(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(Arrays.asList(1));
            if (numRows == 1) {
                return res;
            }

            for (int i = 1; i < numRows; i++) {
                int[] subRes = new int[i + 1];
                subRes[0] = 1;
                subRes[i] = 1;
                for (int j = 1; j < i; j++) {
                    List<Integer> preRes = res.get(res.size() - 1);
                    subRes[j] = preRes.get(j - 1) + preRes.get(j);
                }
                res.add(Arrays.stream(subRes).boxed().collect(Collectors.toList()));
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}