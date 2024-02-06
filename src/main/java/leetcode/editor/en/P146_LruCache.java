//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise 
//return -1. 
// void put(int key, int value) Update the value of the key if the key exists. 
//Otherwise, add the key-value pair to the cache. If the number of keys exceeds 
//the capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10⁴ 
// 0 <= value <= 10⁵ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 20045 👎 9
//51


package leetcode.editor.en;

import java.util.LinkedHashMap;

/**
 * LRU Cache
 *
 * @author DY
 * @date 2024-02-06 10:50:40
 */
public class P146_LruCache {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new P146_LruCache().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    static class LRUCache {
        int cap = 0;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            cap = capacity;
        }

        public int get(int key) {
            makeRecent(key);
            return cache.get(key) == null ? -1 : cache.get(key);
        }

        public void put(int key, int value) {
            // 先判断是更新还是新增
            if(cache.containsKey(key)) {
                cache.put(key, value);
                makeRecent(key);
                return;
            }

            if (cache.size() >= cap) {
                int oldKey = cache.entrySet().iterator().next().getKey();
                cache.remove(oldKey);
            }
            cache.put(key, value);
        }

        private void makeRecent(int key) {
            if (cache.containsKey(key)) {
                int val = cache.remove(key);
                cache.put(key, val);
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
