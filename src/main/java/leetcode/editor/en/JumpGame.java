//You are given an integer array nums. You are initially positioned at the array
//'s first index, and each element in the array represents your maximum jump lengt
//h at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jum
//p length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics Array Dynamic Programming Greedy 
// π 7501 π 465


package leetcode.editor.en;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{3, 0, 8, 2, 0, 0, 1}))
        ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public boolean canJump(int[] nums) {
//            return canJump(Arrays.stream(nums).boxed().collect(Collectors.toList()), 0, new ConcurrentHashMap<>());
//        }

        private boolean canJump(List<Integer> nums, int index, Map<Integer, Boolean> record) {
            boolean canJump = false;
            if (nums.get(0) >= nums.size() - 1) {
                return true;
            } else if (nums.get(0) == 0) {
                return false;
            } else {
//                δ»εεΎειεοΌε εΏ«ιεΊ¦
                for (int i = Math.min(nums.get(0), nums.size() - 1); i >= 1 && !canJump; i--) {
                    if (nums.get(i) == 0) {
                        continue;
                    }
//                    recordη¨ζ₯θ?°ε½ζ―ε¦η»εθΏ
                    if (!record.containsKey(index + i)) {
                        canJump = canJump(nums.subList(i, nums.size()), index + i, record);
                        record.put(index + i, canJump);
                    } else {
                        canJump = record.get(index + i);
                    }
                }
            }
            return canJump;
        }

        // δΈζ¬‘ιεηθ§£ζ³οΌhttps://books.halfrost.com/leetcode/ChapterFour/0001~0099/0055.Jump-Game/
//        ε―Ήζ―δΈͺδ½η½?ηεη΄ ι½ζε?ε―δ»₯ε°θΎΎηζθΏθ·η¦» maxDisοΌδΈζ­ζ΄ζ°ζθΏθ·η¦»οΌε¦ζδ»ζδΈδΈͺεΌε§οΌδΈζ iε€§δΊmaxDisδΊοΌθ―΄ζζ₯δΈδΈδΊ
        public boolean canJump(int[] nums) {
            int l = nums.length;
            if (l == 0) return false;
            if (l == 1) return true;

            int maxDis = 0;
            for (int i = 0; i < l; i++) {
                if (i > maxDis) return false;
                maxDis = Math.max(maxDis, i + nums[i]);
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}