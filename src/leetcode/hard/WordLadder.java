package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class WordLadder {

    /*
    126题，时间复杂度不行
    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    Output:
    [
      ["hit","hot","dot","dog","cog"],
      ["hit","hot","lot","log","cog"]
    ]
     */

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        findNext(lists,list, beginWord,endWord,wordList,-1);
        return lists;
    }
    void findNext(List<List<String>> lists, List<String> list,String beginWord, String endWord, List<String> wordList,int last){
            if (lists.size()!=0 && list.size() == lists.get(0).size()-1){
                if (nextMatch(beginWord,endWord,last) >= 0){
                    List<String> l = new ArrayList<>(list);
                    l.add(endWord);
                    lists.add(l);
                }
                return;
            }
        for (int i = 0; i < wordList.size();i++){
            String cur = wordList.get(i);
            int mm = nextMatch(beginWord,cur,last);
            if (mm >= 0) {
                List<String> l = new ArrayList<>(list);
                l.add(cur);
                if (lists.size()!=0 && l.size() > lists.get(0).size()){
                    break;
                }else {
                    if (cur.equals(endWord)) {
                        if (lists.size()==0){
                            lists.add(l);
                        }else{
                            if (lists.get(0).size() == l.size()){
                                lists.add(l);
                            }else{
                                lists.clear();
                                lists.add(l);
                            }
                        }
                    } else {
                        wordList.remove(i);
                        findNext(lists, l, cur, endWord, wordList,mm);
                        wordList.add(i, cur);
                    }
                }
            }
        }
    }
    int nextMatch(String s,String m,int last){
        int n = -1;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)!=m.charAt(i)){
                if(last == i){
                    return -1;
                }
                if (n >= 0) {
                    return -1;
                } else {
                    n = i;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        List<String>list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        new WordLadder().findLadders("hit","cog",list);
    }
}
