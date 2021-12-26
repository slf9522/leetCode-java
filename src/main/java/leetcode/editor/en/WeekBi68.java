//Given two string arrays words1 and words2, return the number of strings that a
//ppear exactly once in each of the two arrays. 
//
// 
// Example 1: 
//
// 
//Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","le
//etcode","is"]
//Output: 2
//Explanation:
//- "leetcode" appears exactly once in each of the two arrays. We count this str
//ing.
//- "amazing" appears exactly once in each of the two arrays. We count this stri
//ng.
//- "is" appears in each of the two arrays, but there are 2 occurrences of it in
// words1. We do not count this string.
//- "as" appears once in words1, but does not appear in words2. We do not count 
//this string.
//Thus, there are 2 strings that appear exactly once in each of the two arrays.
// 
//
// Example 2: 
//
// 
//Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
//Output: 0
//Explanation: There are no strings that appear in each of the two arrays.
// 
//
// Example 3: 
//
// 
//Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
//Output: 1
//Explanation: The only string that appears exactly once in each of the two arra
//ys is "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= words1.length, words2.length <= 1000 
// 1 <= words1[i].length, words2[j].length <= 30 
// words1[i] and words2[j] consists only of lowercase English letters. 
// 
// 👍 39 👎 0


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WeekBi68 {
    public static void main(String[] args) {
        Solution solution = new WeekBi68().new Solution();
//        recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
//        List<List<String>> ingredients = new ArrayList<>();
//        ingredients.add(Arrays.asList("d"));
//        ingredients.add(Arrays.asList("hveml", "f", "cpivl"));
//        ingredients.add(Arrays.asList("cpivl", "zpmcz", "h", "e", "fzjnm", "ju"));
//        ingredients.add(Arrays.asList("cpivl", "hveml", "zpmcz", "ju", "h"));
//        ingredients.add(Arrays.asList("h", "fzjnm", "e", "q", "x"));
//        ingredients.add(Arrays.asList("d", "hveml", "cpivl", "q", "zpmcz", "ju", "e", "x"));
//        ingredients.add(Arrays.asList("f", "hveml", "cpivl"));
//
//
//        System.out.println(solution.findAllRecipes(new String[]{"ju", "fzjnm", "x", "e", "zpmcz", "h", "q"},
//                ingredients, new String[]{
//                        "f", "hveml", "cpivl", "d"}));
        System.out.println(solution.canBeValid(")",
                "0011"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/discuss/1646582/Python3-Java-C%2B
         * %2B-Counting-Brackets-O(n)
         *
         * @param s
         * @param locked
         * @return
         */
        boolean canBeValid(String s, String locked) {
            int bal = 0, wild = 0, sz = s.length();
            for (int i = 0; i < sz && wild >= 0; i += 1) {
                if (locked.charAt(i) == '1')
                    bal += s.charAt(i) == '(' ? 1 : -1;
                else
                    ++wild;

                if (bal < 0) {
                    --wild;
                    bal = 0;
                }
            }
            return bal <= wild;
        }

        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            List<String> r = Arrays.stream(recipes).collect(Collectors.toList());
            List<String> s = Arrays.stream(supplies).collect(Collectors.toList());
            Set<String> res = new HashSet<>();
            for (int i = 0; i < recipes.length; i++) {
                // 可能有死循环
                findAllRecipes(i, r, ingredients, s, res, new HashSet<>());
            }
            return new ArrayList<>(res);
        }

        private boolean findAllRecipes(int i, List<String> recipes, List<List<String>> ingredients,
                                       List<String> supplies, Set<String> res, Set<String> visit) {
            visit.add(recipes.get(i));
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                String ig = ingredients.get(i).get(j);
                if (supplies.contains(ig)) {
                    continue;
                } else {
                    boolean f = false;
                    for (int k = 0; k < recipes.size(); k++) {
                        if (!visit.contains(ig) && ig.equals(recipes.get(k)) &&
                                (res.contains(ig) || findAllRecipes(k, recipes, ingredients, supplies, res, visit))) {
                            f = true;
                            break;
                        }
                    }
                    if (f) continue;
                }
                return false;
            }
            res.add(recipes.get(i));
            return true;
        }

        public int mostWordsFound(String[] sentences) {
            int res = 0;
            for (int i = 0; i < sentences.length; i++) {
                String t = sentences[i];
                t.trim();
                res = Math.max(res, t.split("").length);
            }
            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}