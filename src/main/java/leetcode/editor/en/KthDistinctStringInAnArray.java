//A distinct string is a string that is present only once in an array. 
//
// Given an array of strings arr, and an integer k, return the kth distinct stri
//ng present in arr. If there are fewer than k distinct strings, return an empty s
//tring "". 
//
// Note that the strings are considered in the order in which they appear in the
// array. 
//
// 
// Example 1: 
//
// 
//Input: arr = ["d","b","c","b","c","a"], k = 2
//Output: "a"
//Explanation:
//The only distinct strings in arr are "d" and "a".
//"d" appears 1st, so it is the 1st distinct string.
//"a" appears 2nd, so it is the 2nd distinct string.
//Since k == 2, "a" is returned. 
// 
//
// Example 2: 
//
// 
//Input: arr = ["aaa","aa","a"], k = 1
//Output: "aaa"
//Explanation:
//All strings in arr are distinct, so the 1st string "aaa" is returned.
// 
//
// Example 3: 
//
// 
//Input: arr = ["a","b","a"], k = 3
//Output: ""
//Explanation:
//The only distinct string is "b". Since there are fewer than 3 distinct strings
//, we return an empty string "".
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= arr.length <= 1000 
// 1 <= arr[i].length <= 5 
// arr[i] consists of lowercase English letters. 
// 
// Related Topics Array Hash Table String Counting 
// 👍 118 👎 3


package leetcode.editor.en;

import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthDistinctStringInAnArray().new Solution();
        System.out.println(solution.kthDistinct(new String[]{
                "d", "b", "c", "b", "c", "a"
        }, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String kthDistinct(String[] arr, int k) {
            String res = "";
            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < arr.length; i++) {
                String si = arr[i];
                if (map.containsKey(si)) {
                    map.put(si, map.get(si) + 1);
                } else {
                    map.put(si, 1);
                }
            }
            String[] keys = map.keySet().toArray(new String[0]);
            int i = 0;
            int cnt = 0;
            while (i < keys.length) {
                if (map.get(keys[i]) == 1 && ++cnt == k) return keys[i];
                i++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}