package leetcode.editor.interview;



import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import org.openjdk.jol.vm.VM;
/**
 * ø
 *
 * @ClassName MaxDepth
 * @Description //TODO
 * @Author fangjiaxin
 * @Date 2021/12/28
 */
public class Paypal {
    // 求树的最大高度：bfs
    public static int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int cnt = 0;

        while (deque.size() > 0) {
            int tmp = deque.size();
            for (int i = 0; i < tmp; i++) {
                TreeNode node = deque.removeFirst();
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            cnt++;
        }
        return cnt;
    }

    // 求树的最大高度：dfs
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = 0, right = 0;
        if (root.left != null) left = maxDepth(root.left);
        if (root.right != null) right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    /**
     * 求一颗树里面两个节点的最大距离
     * @param root
     * @return
     */
    public static int maxDistance(TreeNode root) {
        List<Integer> res = Arrays.asList(0);
        max(root, res);
        return res.get(0);
    }

    public static int max(TreeNode root, List<Integer> res) {
        if (root == null) return 0;

        int left = 0, right = 0;
        if (root.left != null) left = max(root.left, res);
        if (root.right != null) right = max(root.right, res);

        res.set(0, Math.max(res.get(0), left + right + 1));

        return 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        Integer integer1 = new Integer(1);
        System.out.println("integer1的内存地址: " + VM.current().addressOf(integer1));
        Integer integer2 = change(integer1);
        System.out.println("integer2的内存地址: " +  VM.current().addressOf(integer2));
        System.out.println(integer1 == integer2);
    }

    /**
     * 判断integer变量值传递的问题
     * @param a
     * @return
     */
    private static Integer change(Integer a) {
        System.out.println("参数的内存地址: " +  VM.current().addressOf(a));
        a = a + 1;
        System.out.println("返回值的内存地址: " + VM.current().addressOf(a));
        return a;
    }



}
