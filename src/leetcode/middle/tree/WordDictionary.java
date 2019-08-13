package leetcode.middle.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WordDictionary {
    class TreeNode{
        List<Integer> list = new ArrayList<>();
        TreeNode[] children = new TreeNode[26];
        boolean isWord = false;
        TreeNode(){
        }

    }
    TreeNode head;
    public WordDictionary() {
        head = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode node = head;
        for (int i = 0; i < word.length(); i++){
            if (node.children[word.charAt(i) - 'a'] == null){
                node.children[word.charAt(i) - 'a'] = new TreeNode();
                node.list.add(word.charAt(i) - 'a');
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return search(word,head,0);
    }
    public boolean search(String word,TreeNode node, int index){
        if (index == word.length()){
            return node.isWord;
        }
        if (word.charAt(index) == '.'){
            for (int i = 0; i < node.list.size();i++){
                if (search(word,node.children[node.list.get(i)],index + 1)){
                    return true;
                }
            }
            return false;
        }
        if (node.children[word.charAt(index) - 'a'] ==null){
            return false;
        }else
            return search(word,node.children[word.charAt(index) - 'a'],index+1);
    }


    public static void main(String[] args) {
        WordDictionary wd =new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println( wd.search("pad"));
        System.out.println( wd.search("bad"));
        System.out.println( wd.search(".ad"));
        System.out.println( wd.search("b.."));
    }
}
