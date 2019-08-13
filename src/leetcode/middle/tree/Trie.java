package leetcode.middle.tree;

public class Trie {
    /** Initialize your data structure here. */
    class TreeNode {
        char val;
        boolean isWord =false;
        TreeNode(char c){
            this.val = c;
        }
        public TreeNode[] children = new TreeNode[26];
    }
    TreeNode head;
    public Trie() {
        head = new TreeNode(' ');
    }
    private void insert(TreeNode node, String word, int i){
        if (word.length() == i){
            node.isWord = true;
            return;
        }
        char c = word.charAt(i);
        if (node.children[c - 'a'] == null) {
            node.children[c - 'a'] = new TreeNode(c);
        }
        insert(node.children[c-'a'],word,i+1);
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = head;
        for (int i = 0; i< word.length();i++){
            if (node.children[word.charAt(i) - 'a'] ==null){
                node.children[word.charAt(i)  - 'a'] = new TreeNode(word.charAt(i));
            }
            node =  node.children[word.charAt(i)  - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cur = head;
        for (int i = 0; i < word.length();i++){
            if (cur.children[word.charAt(i) - 'a'] != null){
                cur = cur.children[word.charAt(i) - 'a'];
            }else{
                return false;
            }
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur = head;
        for (int i = 0; i < prefix.length();i++){
            if (cur.children[prefix.charAt(i) - 'a'] != null){
                cur = cur.children[prefix.charAt(i)-'a'];
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }
}
