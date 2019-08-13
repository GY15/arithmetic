package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    //212
    public static void main(String[] args) {
        new WordSearch().findWords(new char[][]{{'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}},new String[]{"oath","pea","eat","rain"});
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++){
            trie.insert(words[i]);
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                find(set,"",board,i,j,trie);
            }
        }
        return new ArrayList<>(set);
    }

    private void find(Set<String> set, String str,char[][] board, int i, int j, Trie trie) {
        if (i >= 0 && i < board.length && j>=0&&j<board[0].length && board[i][j]!=' '){
            char cur = board[i][j];
            str +=cur;
            if (trie.search(str)){
                set.add(str);
            }
            if (trie.startsWith(str)){
                board[i][j] = ' ';
                find(set,str,board,i+1,j,trie);
                find(set,str,board,i-1,j,trie);
                find(set,str,board,i,j-1,trie);
                find(set,str,board,i,j+1,trie);
                board[i][j] = cur;
            }
        }
    }

    class Trie {
        /**
         * Initialize your data structure here.
         */
        class TreeNode {
            char val;
            boolean isWord = false;

            TreeNode(char c) {
                this.val = c;
            }

            public TreeNode[] children = new TreeNode[26];
        }

        TreeNode head;

        public Trie() {
            head = new TreeNode(' ');
        }

        private void insert(TreeNode node, String word, int i) {
            if (word.length() == i) {
                node.isWord = true;
                return;
            }
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TreeNode(c);
            }
            insert(node.children[c - 'a'], word, i + 1);
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TreeNode node = head;
            for (int i = 0; i < word.length(); i++) {
                if (node.children[word.charAt(i) - 'a'] == null) {
                    node.children[word.charAt(i) - 'a'] = new TreeNode(word.charAt(i));
                }
                node = node.children[word.charAt(i) - 'a'];
            }
            node.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TreeNode cur = head;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i) - 'a'] != null) {
                    cur = cur.children[word.charAt(i) - 'a'];
                } else {
                    return false;
                }
            }
            return cur.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TreeNode cur = head;
            for (int i = 0; i < prefix.length(); i++) {
                if (cur.children[prefix.charAt(i) - 'a'] != null) {
                    cur = cur.children[prefix.charAt(i) - 'a'];
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}