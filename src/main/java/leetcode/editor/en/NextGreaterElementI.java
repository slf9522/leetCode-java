//The next greater element of some element x in an array is the first greater el
//ement that is to the right of x in the same array. 
//
// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nu
//ms1 is a subset of nums2. 
//
// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[
//j] and determine the next greater element of nums2[j] in nums2. If there is no n
//ext greater element, then the answer for this query is -1. 
//
// Return an array ans of length nums1.length such that ans[i] is the next great
//er element as described above. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//Output: [-1,3,-1]
//Explanation: The next greater element for each value of nums1 is as follows:
//- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so t
//he answer is -1.
//- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
//- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so t
//he answer is -1.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [2,4], nums2 = [1,2,3,4]
//Output: [3,-1]
//Explanation: The next greater element for each value of nums1 is as follows:
//- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
//- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so t
//he answer is -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 104 
// All integers in nums1 and nums2 are unique. 
// All the integers of nums1 also appear in nums2. 
// 
//
// 
//Follow up: Could you find an O(nums1.length + nums2.length) solution? Related 
//Topics Array Hash Table Stack Monotonic Stack 
// 👍 1618 👎 119


package leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        System.out.println(solution.nextGreaterElement(new int[]{1, 3, 5, 2, 4}, new int[]{6, 5, 4, 3, 2, 1, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            Arrays.fill(res, -1);

            Deque<Integer> deque = new ArrayDeque<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i], i);
            }
            for (int i = 0; i < nums2.length; i++) {
                while (deque.size() > 0 && deque.peekLast() < nums2[i]) {
                    if (map.containsKey(deque.peekLast())) {
                        res[map.get(deque.pollLast())] = nums2[i];
                    } else {
                        deque.pollLast();
                    }
                }
                // push是插在头
                deque.addLast(nums2[i]);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}