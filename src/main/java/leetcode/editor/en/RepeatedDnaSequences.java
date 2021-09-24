//The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C
//', 'G', and 'T'. 
//
// 
// For example, "ACGAATTCCG" is a DNA sequence. 
// 
//
// When studying DNA, it is useful to identify repeated sequences within the DNA
//. 
//
// Given a string s that represents a DNA sequence, return all the 10-letter-lon
//g sequences (substrings) that occur more than once in a DNA molecule. You may re
//turn the answer in any order. 
//
// 
// Example 1: 
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//Output: ["AAAAACCCCC","CCCCCAAAAA"]
// Example 2: 
// Input: s = "AAAAAAAAAAAAA"
//Output: ["AAAAAAAAAA"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s[i] is either 'A', 'C', 'G', or 'T'. 
// 
// Related Topics Hash Table String Bit Manipulation Sliding Window Rolling Hash
// Hash Function 
// 👍 1428 👎 361


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
        System.out.println(solution.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    //   todo：字符串hash函数，防止碰撞的算法 https://books.halfrost.com/leetcode/ChapterFour/0100~0199/0187.Repeated-DNA-Sequences/
//    https://leetcode.com/problems/repeated-dna-sequences/discuss/53952/20-ms-solution-(C%2B%2B)-with-explanation

    /**
     * 优化方向：
     * 1、hash不需要做10*n次，每个字符都重新参与一次hash计算，自己计算hash，利用overlap，val = ((val << 2) & mask) | char2val(s[10])
     * 2、不需要（Integer key,Integer value)的hash表，因为value只有3个状态：没遇到、遇到1次，遇到1次以上
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res = new ArrayList<>();
            Map<String, Integer> cnt = new HashMap<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String sub = s.substring(i, i + 10);
                if (cnt.containsKey(sub) && cnt.get(sub) == 1) {
                    res.add(sub);
                }
                cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

