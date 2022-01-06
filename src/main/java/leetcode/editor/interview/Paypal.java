package leetcode.editor.interview;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
     *
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
     *
     * @param a
     * @return
     */
    private static Integer change(Integer a) {
        System.out.println("参数的内存地址: " +  VM.current().addressOf(a));
        a = a + 1;
        System.out.println("返回值的内存地址: " + VM.current().addressOf(a));
        return a;
    }

    // 迭代器和函数式编程
    public void testIterator(String[] args) {
        List<String> models = new ArrayList<String>();
        models.add("model1");
        models.add("model2");
        models.add("model3");
        models.add("model4");

        // 1、报错java.util.ConcurrentModificationException
//        for (String s : models) {
//            if (s.equals("model2")) {
//                models.remove(s);
//            }
//        }
        // 2 正确运行
        models.removeIf(s -> s.equals("model2"));

        // 3 迭代器
        for (Iterator<String> it = models.iterator(); it.hasNext(); ) {
            String s = it.next();
            if (s.equals("model2") || s.equals("model3")) {
                models.remove(s);
//                it.remove();
            }
        }

        System.out.println(models);
    }

    // 懒加载
    public void lazyCalculator(String[] args) {
        Long uid = 1L;
        User user = new User();
        user.setUid(uid);
        // departmentService 是一个rpc调用
        user.setDepartment(Lazy.of(() -> String.valueOf(uid)));

        Lazy<String> departmentLazy = user.department;
        Lazy<Long> supervisorLazy = user.supervisor;

        Lazy<Lazy<Set<String>>> permissions = departmentLazy.map(department ->
                supervisorLazy.map(supervisor -> getPermissions(department, supervisor)));

        Lazy<Set<String>> permissions2 = departmentLazy.flatMap(department ->
                supervisorLazy.map(supervisor -> getPermissions(department, supervisor))
        );

    }

    Set<String> getPermissions(String department, Long supervisor) {
        return new HashSet<>();
    }
}