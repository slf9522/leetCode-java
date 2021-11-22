//Design a data structure to find the frequency of a given value in a given suba
//rray. 
//
// The frequency of a value in a subarray is the number of occurrences of that v
//alue in the subarray. 
//
// Implement the RangeFreqQuery class: 
//
// 
// RangeFreqQuery(int[] arr) Constructs an instance of the class with the given 
//0-indexed integer array arr. 
// int query(int left, int right, int value) Returns the frequency of value in t
//he subarray arr[left...right]. 
// 
//
// A subarray is a contiguous sequence of elements within an array. arr[left...r
//ight] denotes the subarray that contains the elements of nums between indices le
//ft and right (inclusive). 
//
// 
// Example 1: 
//
// 
//Input
//["RangeFreqQuery", "query", "query"]
//[[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
//Output
//[null, 1, 2]
//
//Explanation
//RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 
//33, 22, 12, 34, 56]);
//rangeFreqQuery.query(1, 2, 4); // return 1. The value 4 occurs 1 time in the s
//ubarray [33, 4]
//rangeFreqQuery.query(0, 11, 33); // return 2. The value 33 occurs 2 times in t
//he whole array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 105 
// 1 <= arr[i], value <= 104 
// 0 <= left <= right < arr.length 
// At most 105 calls will be made to query 
// 
// Related Topics Array Binary Search 
// 👍 168 👎 12


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFrequencyQueries {
    public static void main(String[] args) {
        RangeFreqQuery obj = new RangeFreqQuery(new int[]{3, 4, 5, 3, 3, 2, 2, 2, 5, 4});
        System.out.println(obj.query(5, 6, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RangeFreqQuery {
        Map<Integer, List<Integer>> index = new HashMap<>();
        Map<String, Integer> cache = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (!index.containsKey(arr[i])) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    index.put(arr[i], tmp);
                } else {
                    index.get(arr[i]).add(i);
                }
            }
        }

        //        2 0，1
        public int query(int left, int right, int value) {
            String c = String.join(",", String.valueOf(left), String.valueOf(right), String.valueOf(value));
            if (cache.containsKey(c)) return cache.get(c);

            List<Integer> tmp = index.get(value);
            if (tmp == null) return 0;
            Integer[] tmpa = tmp.stream().toArray(Integer[]::new);
            int l = Arrays.binarySearch(tmpa, left);
            int r = Arrays.binarySearch(tmpa, right);
            int res = 0;
            if (l >= 0 && r >= 0) {
                res = r - l + 1;
            } else if (l < 0 && r >= 0) {
                l = -l - 1 - 1;
                res = r - l;
            } else if (l >= 0 && r < 0) {
                r = -r - 1;
                res = r - l;
            } else {
                l = -l - 1 - 1;
                r = -r - 1;
                res = r - l - 1;
            }
            cache.put(c, res);
            return res;
        }
    }

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}