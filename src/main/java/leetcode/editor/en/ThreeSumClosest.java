//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 4072 👎 195


package leetcode.editor.en;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());

            int sumMin = numList.subList(0, 3).stream().reduce(Integer::sum).get();
            int sumMax = numList.subList(numList.size() - 3, numList.size()).stream().reduce(Integer::sum).get();

            if (target < sumMin) {
                return sumMin;
            }
            if (target > sumMax) {
                return sumMax;
            }

            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < numList.size(); i++) {
                while (i > 1 && numList.get(i) == numList.get(i - 1)) {
                    i++;
                    break;
                }

                int ni = numList.get(i);
                int l = i + 1;
                int r = numList.size() - 1;
                while (l < r) {
                    int sum = ni + numList.get(l) + numList.get(r);
                    int diffT = sum - target;
                    diff = Math.abs(diffT) < Math.abs(diff) ? diffT : diff;
                    if (sum > target) {
                        r--;
                        continue;
                    }
                    if (sum < target) {
                        l++;
                        continue;
                    } else {
                        return target;
                    }
                }
            }

            return diff + target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}