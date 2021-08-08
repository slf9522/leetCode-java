//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k
//]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 12181 👎 1189


package leetcode.editor.en;

import com.sun.tools.javac.util.Pair;
import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{0, 3, 0, 1, 1, -1, -5, -5, 3, -3, -3, 0}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    // o(n2)解法
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            // 利用map加速查找，同时记录个数，防止重复
            Map<Integer, Integer> uniqCnt = new HashMap<>();

            for (int num : nums) {
                int cnt = uniqCnt.getOrDefault(num, 0);
                uniqCnt.put(num, ++cnt);
            }
            List<Integer> uniqNums = uniqCnt.keySet().stream().sorted().collect(Collectors.toList());

            for (int i = 0; i < uniqNums.size(); i++) {
                int ni = uniqNums.get(i);
                if (ni * 3 == 0 && uniqCnt.get(ni) >= 3) {
                    res.add(Arrays.asList(ni, ni, ni));
                }
                for (int j = i + 1; j < uniqNums.size(); j++) {
                    int nj = uniqNums.get(j);
                    if (ni * 2 + nj == 0 && uniqCnt.get(ni) >= 2) {
                        res.add(Arrays.asList(ni, ni, nj));
                    }
                    if (ni + nj * 2 == 0 && uniqCnt.get(nj) >= 2) {
                        res.add(Arrays.asList(ni, nj, nj));
                    }
                    int target = -ni - nj;
                    // 按顺序遍历防止重复
                    if (target > nj && uniqCnt.containsKey(target)) {
                        res.add(Arrays.asList(ni, nj, target));
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

// 双指针做法，不需要binarySearch到准确的插入点，直接i+1头尾双指针就可以了