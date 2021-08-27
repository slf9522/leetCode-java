//The set [1, 2, 3, ..., n] contains a total of n! unique permutations. 
//
// By listing and labeling all of the permutations in order, we get the followin
//g sequence for n = 3: 
//
// 
// "123" 1
// "132" 2
// "213" 3
// "231" 4
// "312" 5
// "321" 6
// 
//
// Given n and k, return the kth permutation sequence. 
//
// 
// Example 1: 
// Input: n = 3, k = 3
//Output: "213"
// Example 2: 
// Input: n = 4, k = 9
//Output: "2314"
// Example 3: 
// Input: n = 3, k = 1
//Output: "123"
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics Math Recursion 
// 👍 2690 👎 376


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
public class PermutationSequence {

    public static void main(String[] args) {

        Solution solution = new PermutationSequence().new Solution();
        System.out.println(solution.getPermutation(3, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> input = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
            List<Integer> outPut = new ArrayList<>();
            getNext(input, k, outPut);
            return outPut.stream().map(String::valueOf).collect(Collectors.joining(""));
        }

        /**
         * @param prePare 还可以用prepare里的数字枚举
         * @param k       第k个数
         * @return
         */
        private void getNext(List<Integer> prePare, int k, List<Integer> output) {
            if (prePare.size() == 1) {
                output.add(prePare.get(0));
                return;
            }

            int n = prePare.size();
            int subPermutations = genPermuattion(n - 1);
            int index = k / subPermutations;
            if (index * subPermutations == k && index != 0) {
                index--;
            }
            output.add(prePare.remove(index));
            getNext(prePare, k - index * subPermutations, output);
        }

        private int genPermuattion(int n) {
            return IntStream.rangeClosed(1, n).boxed().reduce(1, (sub, ele) -> sub * ele);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}