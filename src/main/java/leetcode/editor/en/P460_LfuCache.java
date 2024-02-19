//Design and implement a data structure for a Least Frequently Used (LFU) cache.
// 
//
// Implement the LFUCache class: 
//
// 
// LFUCache(int capacity) Initializes the object with the capacity of the data 
//structure. 
// int get(int key) Gets the value of the key if the key exists in the cache. 
//Otherwise, returns -1. 
// void put(int key, int value) Update the value of the key if present, or 
//inserts the key if not already present. When the cache reaches its capacity, it 
//should invalidate and remove the least frequently used key before inserting a new 
//item. For this problem, when there is a tie (i.e., two or more keys with the same 
//frequency), the least recently used key would be invalidated. 
// 
//
// To determine the least frequently used key, a use counter is maintained for 
//each key in the cache. The key with the smallest use counter is the least 
//frequently used key. 
//
// When a key is first inserted into the cache, its use counter is set to 1 (
//due to the put operation). The use counter for a key in the cache is incremented 
//either a get or put operation is called on it. 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//Explanation
//// cnt(x) = the use counter for key x
//// cache=[] will show the last used order for tiebreakers (leftmost element 
//is  most recent)
//LFUCache lfu = new LFUCache(2);
//lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lfu.get(1);      // return 1
//                 // cache=[1,2], cnt(2)=1, cnt(1)=2
//lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, 
//invalidate 2.
//                 // cache=[3,1], cnt(3)=1, cnt(1)=2
//lfu.get(2);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,1], cnt(3)=2, cnt(1)=2
//lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1
//.
//                 // cache=[4,3], cnt(4)=1, cnt(3)=2
//lfu.get(1);      // return -1 (not found)
//lfu.get(3);      // return 3
//                 // cache=[3,4], cnt(4)=1, cnt(3)=3
//lfu.get(4);      // return 4
//                 // cache=[4,3], cnt(4)=2, cnt(3)=3
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 10⁴ 
// 0 <= key <= 10⁵ 
// 0 <= value <= 10⁹ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// 
// 
//
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 5491 👎 32
//4


package leetcode.editor.en;

import java.util.*;

/**
 * LFU Cache
 *
 * @author DY
 * @date 2024-02-06 11:19:49
 */
public class P460_LfuCache {
    public void main(String[] args) {
        //测试代码
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        int cap = 0;

        // frq -> key list 改成linkedHashSet更好，因为可以快速定位，是否存在某个key
        TreeMap<Integer, LinkedList<Node>> freqM = new TreeMap<>();
        Map<Integer, Node> nodes = new HashMap<>();

        public LFUCache(int capacity) {
            cap = capacity;
        }

        public int get(int key) {
            if (nodes.containsKey(key)) {
                Node node = nodes.get(key);
                incr(node);
                return node.val;
            }
            return -1;
        }

        private void incr(Node node) {
            List<Node> nodes = freqM.get(node.freq);
            nodes.remove(node);

            node.freq++;
            addFreq(node);
        }

        public void put(int key, int value) {
            if (nodes.containsKey(key)) {
                Node node = nodes.get(key);
                node.val = value;
                incr(node);
            } else {
                if (nodes.size() >= cap) {
                    List<Node> nodesToRemove = freqM.entrySet().iterator().next().getValue();
                    while(nodesToRemove.isEmpty()){
                        int k = freqM.entrySet().iterator().next().getKey();
                        freqM.remove(k);
                        nodesToRemove = freqM.entrySet().iterator().next().getValue();
                    }
                    Node n = nodesToRemove.remove(0);
                    nodes.remove(n.key);

                }
                Node node = new Node(key, value, 1);
                nodes.put(key, node);
                addFreq(node);

            }
        }

        private void addFreq(Node node) {
            int nFreq = node.freq;

            if (freqM.containsKey(nFreq)) {
                freqM.get(nFreq).addLast(node);
            } else {
                freqM.put(nFreq, new LinkedList<>());
                freqM.get(nFreq).addLast(node);
            }
        }
    }

    class Node {
        int key;
        int val;

        int freq;

        public Node(int k, int v, int i) {
            key = k;
            val = v;
            freq = i;
        }
    }
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
