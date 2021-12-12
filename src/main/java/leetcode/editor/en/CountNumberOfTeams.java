//There are n soldiers standing in a line. Each soldier is assigned a unique rat
//ing value. 
//
// You have to form a team of 3 soldiers amongst them under the following rules:
// 
//
// 
// Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rat
//ing[k]). 
// A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > ratin
//g[j] > rating[k]) where (0 <= i < j < k < n). 
// 
//
// Return the number of teams you can form given the conditions. (soldiers can b
//e part of multiple teams). 
//
// 
// Example 1: 
//
// 
//Input: rating = [2,5,3,4,1]
//Output: 3
//Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (
//5,3,1). 
// 
//
// Example 2: 
//
// 
//Input: rating = [2,1,3]
//Output: 0
//Explanation: We can't form any team given the conditions.
// 
//
// Example 3: 
//
// 
//Input: rating = [1,2,3,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// n == rating.length 
// 3 <= n <= 1000 
// 1 <= rating[i] <= 105 
// All the integers in rating are unique. 
// 
// Related Topics Array Dynamic Programming Binary Indexed Tree 
// 👍 1596 👎 148


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CountNumberOfTeams {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfTeams().new Solution();
        System.out.println(solution.numTeams(new int[]{
                2, 5, 3, 4, 1
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTeams(int[] rating) {
            List<Integer> list = Arrays.stream(rating).boxed().collect(Collectors.toList());
            int res = numTeams2(list);
            Collections.reverse(list);
            res += numTeams2(list);
            return res;
        }

        public int numTeams2(List<Integer> rating) {
            int res = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < rating.size(); i++) {
                int r = rating.get(i);
                int cnt = 0;
                for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                    if (e.getKey() < r && e.getValue() >= 1) {
                        cnt++;
                        res += e.getValue();
                    } else if (e.getKey() < r && e.getValue() == 0) {
                        cnt++;
                    } else if (e.getValue() > r) {
                        break;
                    }
                }
                map.put(r, cnt);
            }
            return res;
        }


//        https://leetcode.com/problems/count-number-of-teams/discuss/554795/C%2B%2BJava-O(n-*-n)-and-O(n-log-n)
        /**
         * 对位置r = rating[i]的元素来说 x=左边小于r的元素个数，y=右边大于r的元素个数，res+= x*y 
         */
    }
//leetcode submit region end(Prohibit modification and deletion)

}