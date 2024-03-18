//给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化
//，使之能够遍历这个列表中的所有整数。 
//
// 实现扁平迭代器类 NestedIterator ： 
//
// 
// NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。 
// int next() 返回嵌套列表的下一个整数。 
// boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。 
// 
//
// 你的代码将会用下述伪代码检测： 
//
// 
//initialize iterator with nestedList
//res = []
//while iterator.hasNext()
//    append iterator.next() to the end of res
//return res 
//
// 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。 
//
// 
//
// 示例 1： 
//
// 
//输入：nestedList = [[1,1],2,[1,1]]
//输出：[1,1,2,1,1]
//解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2： 
//
// 
//输入：nestedList = [1,[4,[6]]]
//输出：[1,4,6]
//解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nestedList.length <= 500 
// 嵌套列表中的整数值在范围 [-10⁶, 10⁶] 内 
// 
//
// Related Topics 栈 树 深度优先搜索 设计 队列 迭代器 👍 541 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 扁平化嵌套列表迭代器
 *
 * @author JX
 * @date 2024-03-14 14:00:08
 */
public class P341_FlattenNestedListIterator {
    public static void main(String[] args) {
        //测试代码
//	 	 Solution solution = new P341_FlattenNestedListIterator().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
//    public class NestedIterator implements Iterator<Integer> {
//        List<Integer> res = new ArrayList<>();
//        int curr = 0, size = 0;
//        public NestedIterator(List<NestedInteger> nestedList) {
//            helper(nestedList);
//            size = res.size();
//            return;
//        }
//
//        private void helper(List<NestedInteger> nestedList) {
//            for (NestedInteger item: nestedList) {
//                if (item.isInteger()) {
//                    res.add(item.getInteger());
//                } else {
//                    helper(item.getList());
//                }
//            }
//            return;
//        }
//
//        @Override
//        public Integer next() {
//            return res.get(curr++);
//        }
//
//        @Override
//        public boolean hasNext() {
//            return (curr < size);
//        }
//    }


    public class NestedIterator implements Iterator<Integer> {
        Deque<NestedInteger> stack = new ArrayDeque<> ();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i > -1; --i) {
                stack.push(nestedList.get(i));
            }
            return;
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            if (stack.isEmpty()) return false;
            while (!stack.isEmpty()) {
                if (stack.peek().isInteger()) return true;
                NestedInteger curr = stack.pop();
                for (int i = curr.getList().size() - 1; i > -1; --i) {
                    stack.push(curr.getList().get(i));
                }
            }
            return false;
        }
    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */
//leetcode submit region end(Prohibit modification and deletion)

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single intege
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested lis
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}