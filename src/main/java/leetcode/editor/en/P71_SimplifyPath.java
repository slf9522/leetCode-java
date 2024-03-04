//Given a string path, which is an absolute path (starting with a slash '/') to 
//a file or directory in a Unix-style file system, convert it to the simplified 
//canonical path. 
//
// In a Unix-style file system, a period '.' refers to the current directory, a 
//double period '..' refers to the directory up a level, and any multiple 
//consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, 
//any other format of periods such as '...' are treated as file/directory names. 
//
// The canonical path should have the following format: 
//
// 
// The path starts with a single slash '/'. 
// Any two directories are separated by a single slash '/'. 
// The path does not end with a trailing '/'. 
// The path only contains the directories on the path from the root directory 
//to the target file or directory (i.e., no period '.' or double period '..') 
// 
//
// Return the simplified canonical path. 
//
// 
// Example 1: 
//
// 
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory 
//name.
// 
//
// Example 2: 
//
// 
//Input: path = "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the 
//root level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: path = "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced 
//by a single one.
// 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 3000 
// path consists of English letters, digits, period '.', slash '/' or '_'. 
// path is a valid absolute Unix path. 
// 
//
// Related Topics String Stack 👍 5358 👎 1224


package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Simplify Path
 *
 * @author JX
 * @date 2024-03-04 15:43:32
 */
public class P71_SimplifyPath {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P71_SimplifyPath().new Solution();
        System.out.println(solution.simplifyPath("/home/"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            String[] split = path.split("/");
            List<String> elements = Arrays.stream(split).filter(e -> !e.equals("")).collect(Collectors.toList());

            String res = "/";
            for (int i = 0; i < elements.size(); i++) {
                String ele = elements.get(i);
                if (ele.equals(".")) {
                    continue;
                } else if (ele.equals("..")) {
                    if (stack.size() == 0) continue;
                    stack.pop();
                } else {
                    stack.push(ele);
                }
            }
            for (int i = 0; i < stack.size(); i++) {
                res += stack.get(i);
                if (i != stack.size() - 1) res += "/";
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
