//You are given an array of strings equations that represent relationships 
//between variables where each string equations[i] is of length 4 and takes one of two 
//different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (
//not necessarily different) that represent one-letter variable names. 
//
// Return true if it is possible to assign integers to variable names so as to 
//satisfy all the given equations, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: equations = ["a==b","b!=a"]
//Output: false
//Explanation: If we assign say, a = 1 and b = 1, then the first equation is 
//satisfied, but not the second.
//There is no way to assign the variables to satisfy both equations.
// 
//
// Example 2: 
//
// 
//Input: equations = ["b==a","a==b"]
//Output: true
//Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
// 
//
// 
// Constraints: 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] is a lowercase letter. 
// equations[i][1] is either '=' or '!'. 
// equations[i][2] is '='. 
// equations[i][3] is a lowercase letter. 
// 
//
// Related Topics Array String Union Find Graph 👍 3643 👎 58


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Satisfiability of Equality Equations
 *
 * @author DY
 * @date 2024-02-10 16:26:05
 */
public class P990_SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P990_SatisfiabilityOfEqualityEquations().new Solution();
        System.out.println(solution.equationsPossible(new String[]{"a==b","b!=a"}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equationsPossible(String[] equations) {
            Set<String> equal = new HashSet<>();
            Set<String> unequal = new HashSet<>();


            for (int i = 0; i < equations.length; i++) {
                String equation = equations[i];
                if (equation.contains("==")){
                    equal.add(equation);
                } else {
                    unequal.add(equation);
                }
            }
            UF uf = new UF();
            for (String eq: equal){
                char left = eq.charAt(0);
                char right = eq.charAt(3);
                uf.connect(left, right);
            }

            for(String uneq: unequal){
                char left = uneq.charAt(0);
                char right = uneq.charAt(3);
                if(uf.connected(left, right)) return false;
            }
            return true;
        }
    }

    class UF{

        int[] parent = new int[26];
        public UF(){
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        public void connect(char left, char right){
            int num1 = left -'a';
            int num2 = right -'a';
            int index1 = findParent(num1);
            int index2 = findParent(num2);
            parent[index1] = index2;
        }

        public boolean connected(char left, char right){
            int num1 = left -'a';
            int num2 = right -'a';
            int index1 = findParent(num1);
            int index2 = findParent(num2);
            return index1 == index2;
        }

        public int findParent(int num) {
            if (parent[num] == num){
                return num;
            }
            return findParent(parent[num]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
