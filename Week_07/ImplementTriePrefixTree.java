//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树
// 👍 457 👎 0


//实现 Trie (前缀树)

public class ImplementTriePrefixTree{
    public static void main(String[] args) {
        //测试代码
        Trie solution = new ImplementTriePrefixTree().new Trie();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private boolean isEnd;
        private Trie[] next;

        /** Initialize your data structure here. */
        public Trie() {
            next = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    //如果在字典里面没查到，新建，并以此为起点添加下一个字符
                    cur.next[index] = new Trie();
                }
                cur = cur.next[index];
            }
            //插入完最后一个字符设置为end
            cur.setEnd(true);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie cur = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (cur.next[index] == null) return false;
                cur = cur.next[index];
            }
            //遍历到最后，如果最后子节点是end那么就表示有该元素
            return cur.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie cur = this;
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                //任意一个字符找不到，则没有前缀，否则遍历完就是了
                if (cur.next[index] == null) return false;
                cur = cur.next[index];
            }
            return true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
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