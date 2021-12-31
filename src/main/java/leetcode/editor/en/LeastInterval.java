//A trie (pronounced as "try") or prefix tree is a tree data structure used to e
//fficiently store and retrieve keys in a dataset of strings. There are various ap
//plications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (i
//.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously inser
//ted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 104 calls in total will be made to insert, search, and startsWith
//. 
// 
// Related Topics Hash Table String Design Trie 
// 👍 6079 👎 83


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LeastInterval {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // -1 -2 -1
        System.out.println(solution.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//
//        public int leastInterval(char[] tasks, int n) {
//            if (tasks.length == 0) return 0;
//
//            Map<Character, Integer> map = new HashMap<>();
//
//            int min = 0;
//            for (char c : tasks) {
//                map.merge(c, 1, Integer::sum);
//                min = Math.min(min, map.get(c));
//            }
//
//
//            int res = 0;
//            List<Character> list = new LinkedList<>(map.keySet());
//
//            if (n < list.size()) {
//
//            }
//
//            while (list.size() > 0) {
//                res += list.size();
//
//                // 需要等待
//                if (n >= list.size()) {
//                    for (int i = 0; i < list.size(); i++) {
//                        if (map.containsKey(list.get(i)) && map.get(list.get(i)) == 1) {
//                            map.remove(list.get(i));
//                        } else if (map.containsKey(list.get(i))) {
//                            map.put(list.get(i), map.get(list.get(i)) - 1);
//                        }
//                    }
//                    int tmp = Math.max(n - list.size() + 1, 0);
//                    list = new LinkedList<>(map.keySet());
//                    if (list.size() > 0) res += tmp;
//                }
//
//            }
//            return res;
//        }
//    }

    /**
     * 1, 4, 2, 5, 3
     * 0  1  2  3  4
     */
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            if (nums.length == 1) return nums[0] == k ? 1 : 0;

            int[] sum = new int[nums.length];
            sum[0] = nums[0];

            HashMap<Integer, List<Integer>> map = new HashMap<>();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(0);
            map.put(nums[0], tmp);

            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
                map.putIfAbsent(sum[i], new ArrayList<>());
                map.get(sum[i]).add(i);
            }

            int res = 0;
            for (int i = sum.length - 1; i >= 0; i--) {
                if (sum[i] - k >= 0 && map.containsKey(sum[i] - k)) {
                    int t = sum[i] == sum[i] - k ? map.get(sum[i] - k).size() - 1 : map.get(sum[i] - k).size();
                    res += t;
                }
            }
            return res;
        }

        public int[] productExceptSelf(int[] nums) {
            int[] res = new int[nums.length];
            int left = 1, right = 1;

            for (int i = 0; i < nums.length; i++) {
                res[i] *= left;
                left = res[i];

                res[nums.length - 1 - i] *= right;
                right = res[nums.length - 1 - i];
            }
            return res;
        }

        public int sumOddLengthSubarrays(int[] arr) {
            int res = 0;
            int[] sum = new int[arr.length];

            for (int i = 2
                 ; i < arr.length; i++) {

            }

            return res;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}