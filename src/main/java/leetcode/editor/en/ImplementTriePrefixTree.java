//A trie (pronounced as "try") or prefix tree is a tree data structure used to e
//fficiently store and retrieve keys in a dataset of strings. There are various ap
//plications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (i
//.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously inser
//ted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 104 calls in total will be made to insert, search, and startsWith
//. 
// 
// Related Topics Hash Table String Design Trie 
// 👍 6079 👎 83


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        private final Node node = new Node();

        public Trie() {
        }

        public void insert(String word) {
            List<String> chars = Arrays.stream(word.split("")).collect(Collectors.toList());

            Node n = node;
            for (int i = 0; i < chars.size(); i++) {
                String c = chars.get(i);
                Map<String, Node> m = n.childern;

                if (!m.containsKey(c)) {
                    m.put(c, new Node(c));
                }

                if (i == chars.size() - 1) {
                    m.get(c).isVal = true;
                }

                n = m.get(c);
            }
        }

        public boolean search(String word) {
            List<String> chars = Arrays.stream(word.split("")).collect(Collectors.toList());

            Node n = node;
            for (int i = 0; i < chars.size(); i++) {
                String c = chars.get(i);
                Map<String, Node> m = n.childern;

                if (!m.containsKey(c)) {
                    return false;
                }

                n = m.get(c);
            }
            return n.isVal;
        }

        public boolean startsWith(String prefix) {
            List<String> chars = Arrays.stream(prefix.split("")).collect(Collectors.toList());

            Node n = node;
            for (int i = 0; i < chars.size(); i++) {
                String c = chars.get(i);
                Map<String, Node> m = n.childern;

                if (!m.containsKey(c)) {
                    return false;
                }

                n = m.get(c);
            }
            return true;
        }
    }

    public class Node {
        String val;
        Map<String, Node> childern = new HashMap<>();
        boolean isVal = false;

        Node() {
        }

        Node(String val) {
            this.val = val;
        }

        Node(String val, Node node) {
            this.val = val;
            this.childern.put(val, node);
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}