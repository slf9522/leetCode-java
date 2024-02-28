//You have a lock in front of you with 4 circular wheels. Each wheel has 10 
//slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate 
//freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
//Each move consists of turning one wheel one slot. 
//
// The lock initially starts at '0000', a string representing the state of the 4
// wheels. 
//
// You are given a list of deadends dead ends, meaning if the lock displays any 
//of these codes, the wheels of the lock will stop turning and you will be unable 
//to open it. 
//
// Given a target representing the value of the wheels that will unlock the 
//lock, return the minimum total number of turns required to open the lock, or -1 if 
//it is impossible. 
//
// 
// Example 1: 
//
// 
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation: 
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
//01" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" 
//would be invalid,
//because the wheels of the lock become stuck after the display becomes the 
//dead end "0102".
// 
//
// Example 2: 
//
// 
//Input: deadends = ["8888"], target = "0009"
//Output: 1
//Explanation: We can turn the last wheel in reverse to move from "0000" -> "000
//9".
// 
//
// Example 3: 
//
// 
//Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//Output: -1
//Explanation: We cannot reach the target without getting stuck.
// 
//
// 
// Constraints: 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target will not be in the list deadends. 
// target and deadends[i] consist of digits only. 
// 
//
// Related Topics Array Hash Table String Breadth-First Search 👍 3881 👎 146


package leetcode.editor.en;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Open the Lock
 *
 * @author JX
 * @date 2024-02-24 08:59:44
 */
public class P752_OpenTheLock {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P752_OpenTheLock().new Solution();
        System.out.println(solution.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            HashSet<String> visited = new HashSet<>();
            Set<String> deadSet = Arrays.stream(deadends).collect(Collectors.toSet());

            // corner case
            if(deadSet.contains("0000")) return -1;

            Queue<String> q = new LinkedList<>();
            q.offer("0000");
            // offer的时候就要判断
            visited.add("0000");
            int path = 0;

            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    String before = q.poll();
                    if (before.equals(target)) {
                        return path;
                    }

                    for (int j = 0; j < 4; j++) {
                        String up = getNext(before, j,true);
                        String down = getNext(before, j,false);
                        if (!visited.contains(up) && !deadSet.contains(up)) {
                            visited.add(up);
                            q.offer(up);
                        }
                        if (!visited.contains(down) && !deadSet.contains(down)) {
                            visited.add(down);
                            q.offer(down);
                        }
                    }

                }
                path++;
            }
            return -1;
        }

        String getNext(String before, int j, boolean up) {
            char[] b = before.toCharArray();
            if(up) {
                char c = b[j];
                if(c == '9'){
                    b[j] = '0';
                } else{
                    b[j] += 1;
                }
            } else {
                char c = b[j];
                if(c == '0'){
                    b[j] = '9';
                } else{
                    b[j] -= 1;
                }
            }
            return new String(b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
