//给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发
//。 
//
// 每分钟，如果节点满足以下全部条件，就会被感染： 
//
// 
// 节点此前还没有感染。 
// 节点与一个已感染节点相邻。 
// 
//
// 返回感染整棵树需要的分钟数。 
//
// 
//
// 示例 1： 
// 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
//输出：4
//解释：节点按以下过程被感染：
//- 第 0 分钟：节点 3
//- 第 1 分钟：节点 1、10、6
//- 第 2 分钟：节点5
//- 第 3 分钟：节点 4
//- 第 4 分钟：节点 9 和 2
//感染整棵树需要 4 分钟，所以返回 4 。
// 
//
// 示例 2： 
// 输入：root = [1], start = 1
//输出：0
//解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 每个节点的值 互不相同 
// 树中必定存在值为 start 的节点 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 63 👎 0


package leetcode.editor.cn;

import java.util.*;

import static org.apache.commons.collections.MapUtils.getMap;

/**
 * 感染二叉树需要的总时间
 *
 * @author JX
 * @date 2024-04-24 08:23:56
 */
public class P2385_AmountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2385_AmountOfTimeForBinaryTreeToBeInfected().new Solution();
//        System.out.println(solution.amountOfTime(new TreeNode(1, new TreeNode(5), new TreeNode(3)), 3));
        System.out.println(solution.amountOfTime(new TreeNode(1), 1));

    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int amountOfTime(TreeNode root, int start) {

            Map<Integer, List<TreeNode>> map = new HashMap<>();
            getMap(root, map, null);

            LinkedList<Integer> list = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            int cnt = 0;
            list.add(start);
            visited.add(start);
            while (!list.isEmpty()) {
                int s = list.size();
                for (int i = 0; i < s; i++) {
                    int v = list.pollFirst();
                    for (int j = 0; j < map.get(v).size(); j++) {
                        int next = map.get(v).get(j).val;
                        if (!visited.contains(next)) list.addLast(next);
                        visited.add(next);
                    }
                }
                cnt++;
            }
            return cnt-1;
        }

        void getMap(TreeNode root, Map<Integer, List<TreeNode>> map, TreeNode pre) {
            if (root == null) return;
            map.put(root.val, new ArrayList<>());
            if (pre != null) map.get(root.val).add(pre);
            if (root.left != null) {
                map.get(root.val).add(root.left);
                getMap(root.left, map, root);
            }
            if (root.right != null) {
                map.get(root.val).add(root.right);
                getMap(root.right, map, root);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}