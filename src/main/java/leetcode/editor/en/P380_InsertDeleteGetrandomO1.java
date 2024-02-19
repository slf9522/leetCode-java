//Implement the RandomizedSet class: 
//
// 
// RandomizedSet() Initializes the RandomizedSet object. 
// bool insert(int val) Inserts an item val into the set if not present. 
//Returns true if the item was not present, false otherwise. 
// bool remove(int val) Removes an item val from the set if present. Returns 
//true if the item was present, false otherwise. 
// int getRandom() Returns a random element from the current set of elements (
//it's guaranteed that at least one element exists when this method is called). 
//Each element must have the same probability of being returned. 
// 
//
// You must implement the functions of the class such that each function works 
//in average O(1) time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", 
//"insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//Output
//[null, true, false, true, 2, true, false, 2]
//
//Explanation
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was 
//inserted successfully.
//randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
//randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now 
//contains [1,2].
//randomizedSet.getRandom(); // getRandom() should return either 1 or 2 
//randomly.
//randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now 
//contains [2].
//randomizedSet.insert(2); // 2 was already in the set, so return false.
//randomizedSet.getRandom(); // Since 2 is the only number in the set, 
//getRandom() will always return 2.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// At most 2 * 10⁵ calls will be made to insert, remove, and getRandom. 
// There will be at least one element in the data structure when getRandom is 
//called. 
// 
//
// Related Topics Array Hash Table Math Design Randomized 👍 8978 👎 583


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * Insert Delete GetRandom O(1)
 *
 * @author DY
 * @date 2024-02-06 14:21:57
 */
public class P380_InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
        //测试代码
        Random rand = new Random();
        int n = rand.nextInt(100);
        n += 1;

        System.out.println(n);

//        RandomizedSet solution = new P380_InsertDeleteGetrandomO1().new RandomizedSet();
////        System.out.println(solution.remove(0));
////        System.out.println(solution.remove(0));
////        System.out.println(solution.insert(0));
////        System.out.println(solution.getRandom());
////        System.out.println(solution.remove(0));
////        System.out.println(solution.insert(0));
//
//
//        System.out.println(solution.insert(1));
//        System.out.println(solution.remove(2));
//        System.out.println(solution.insert(2));
//        System.out.println(solution.getRandom());
//        System.out.println(solution.remove(1));
//        System.out.println(solution.insert(2));
//        System.out.println(solution.getRandom());

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {

        // for random
        List<Integer> arrayList = new ArrayList<>();
        // for key -> index mapping
        HashMap<Integer, Integer> keyIndexMap = new HashMap<>();


        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (!keyIndexMap.containsKey(val)) {
                keyIndexMap.put(val, arrayList.size());
                arrayList.add(val);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (keyIndexMap.containsKey(val)) {
                int index = keyIndexMap.remove(val);
                arrayList.set(index, arrayList.get(arrayList.size() - 1));
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            int index = (int) (Math.random() * arrayList.size());
            return arrayList.get(index);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
