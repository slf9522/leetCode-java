//You are given an array of integers nums, there is a sliding window of size k 
//which is moving from the very left of the array to the very right. You can only 
//see the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic 
//Queue 👍 17743 👎 637


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Sliding Window Maximum
 *
 * @author JX
 * @date 2024-02-26 09:49:19
 */
public class P239_SlidingWindowMaximum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P239_SlidingWindowMaximum().new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1}, 1)));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> dq = new LinkedList<>();
            int length = nums.length;
            int[] res = new int[length - k + 1];

            int publish = k-1;
            int cnt = 0;
            for (int i = 0; i < length; i++) {
                int v = nums[i];
                while (dq.size() != 0 && nums[dq.peekLast()] < v) {
                    dq.pollLast();
                }
                dq.offerLast(i);
                if(dq.peekLast() - dq.peekFirst()  == k){
                    dq.pollFirst();
                }
                if(i==publish){
                    res[cnt++] = nums[dq.peekFirst()];
                    publish++;
                }

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
