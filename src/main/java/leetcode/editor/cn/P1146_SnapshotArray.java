//实现支持下列接口的「快照数组」- SnapshotArray： 
//
// 
// SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。 
// void set(index, val) - 会将指定索引 index 处的元素设置为 val。 
// int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。 
// int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。 
// 
//
// 
//
// 示例： 
//
// 输入：["SnapshotArray","set","snap","set","get"]
//     [[3],[0,5],[],[0,6],[0,0]]
//输出：[null,null,0,null,5]
//解释：
//SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
//snapshotArr.set(0,5);  // 令 array[0] = 5
//snapshotArr.snap();  // 获取快照，返回 snap_id = 0
//snapshotArr.set(0,6);
//snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5 
//
// 
//
// 提示： 
//
// 
// 1 <= length <= 50000 
// 题目最多进行50000 次set，snap，和 get的调用 。 
// 0 <= index < length 
// 0 <= snap_id < 我们调用 snap() 的总次数 
// 0 <= val <= 10^9 
// 
//
// Related Topics 设计 数组 哈希表 二分查找 👍 166 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 快照数组
 *
 * @author JX
 * @date 2024-04-27 09:25:17
 */
public class P1146_SnapshotArray {
    public static void main(String[] args) {
        //测试代码
//	 	 Solution solution = new P1146_SnapshotArray().new Solution();
//        SnapshotArray snapshotArray = new SnapshotArray(3);
//        snapshotArray.set(0, 5);
//        snapshotArray.snap();
//        snapshotArray.set(0, 6);
//        System.out.println(snapshotArray.get(0, 0));

//        SnapshotArray snapshotArray = new SnapshotArray(4);
//        snapshotArray.snap();
//        snapshotArray.snap();
//
//        snapshotArray.get(3, 1);
//        snapshotArray.set(2, 4);
//        snapshotArray.snap();
//        snapshotArray.set(1, 4);
        SnapshotArray snapshotArray = new SnapshotArray(2);
        snapshotArray.set(0, 12);
        snapshotArray.snap();
        snapshotArray.snap();
        System.out.println(snapshotArray.get(1, 0));
        System.out.println(snapshotArray.get(1, 0));

        snapshotArray.snap();
        snapshotArray.snap();

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    static class SnapshotArray {
        int snap = 0;

        Map<Integer, Integer>[] snapMap;


        public SnapshotArray(int length) {
            snapMap = new Map[length];
            for (int i = 0; i < length; i++) {
                snapMap[i] = new TreeMap<>();
            }
        }

        public void set(int index, int val) {
            snapMap[index].put(snap, val);
        }

        public int snap() {
            snap++;
            return snap - 1;
        }

        public int get(int index, int snap_id) {
            TreeMap<Integer, Integer> tm = (TreeMap<Integer, Integer>) snapMap[index];
            Integer key = tm.floorKey(snap_id);
            if (key == null) return 0;
            return snapMap[index].get(key);
        }
    }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
//leetcode submit region end(Prohibit modification and deletion)

}