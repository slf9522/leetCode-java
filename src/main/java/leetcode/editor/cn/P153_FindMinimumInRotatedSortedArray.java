//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变
//化后可能得到：
//
// 
// 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2] 
// 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7] 
// 
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], 
//..., a[n-2]] 。 
//
// 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
//解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//解释：原数组为 [0,1,2,4,5,6,7] ，旋转 3 次得到输入数组。
// 
//
// 示例 3： 
//
// 
//输入：nums = [11,13,15,17]
//输出：11
//解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数 互不相同 
// nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转 
// 
//
// Related Topics 数组 二分查找 👍 1085 👎 0


package leetcode.editor.cn;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author JX
 * @date 2024-03-17 09:42:28
 */
public class P153_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P153_FindMinimumInRotatedSortedArray().new Solution();
        System.out.println(solution.findMin(new int[]{2,1}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            if (nums[lo] < nums[hi]) return nums[lo];


            while (lo != hi) {
                if (nums[lo] < nums[hi]) return nums[lo];
                int mid = lo + (hi - lo) / 2;
                int v = nums[mid];
                if (v > nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return nums[hi];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}