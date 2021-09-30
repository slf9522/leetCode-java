//Given an array of integers arr, return true if we can partition the array into
// three non-empty parts with equal sums. 
//
// Formally, we can partition the array if we can find indexes i + 1 < j with (a
//rr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == a
//rr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 
//
// 
// Example 1: 
//
// 
//Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
//Output: true
//Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
// 
//
// Example 2: 
//
// 
//Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
//Output: true
//Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
// 
//
// 
// Constraints: 
//
// 
// 3 <= arr.length <= 5 * 104 
// -104 <= arr[i] <= 104 
// 
// Related Topics Array Greedy 
// 👍 882 👎 103


package leetcode.editor.en;

import java.util.Arrays;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args) {
        Solution solution = new PartitionArrayIntoThreePartsWithEqualSum().new Solution();
        System.out.println(solution.canThreePartsEqualSum(new int[]{1, -1, 1, -1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canThreePartsEqualSum(int[] arr) {
            int sum = Arrays.stream(arr).sum();
            int target = sum / 3;
            if (target * 3 != sum) return false;

            // 注意边界条件，如果从0开始，target=0的case跑不过
            int left = arr[0], right = arr[arr.length - 1];
            int i = 1, j = arr.length - 2;
            while (left != target && i < j) {
                left += arr[i++];
            }
            while (right != target && i < j) {
                right += arr[j--];
            }
            return left == target && right == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}