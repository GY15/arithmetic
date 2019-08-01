package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    //140题 超时
    /*
        Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

        Note:

        The same word in the dictionary may be reused multiple times in the segmentation.
        You may assume the dictionary does not contain duplicate words.
        Example 1:

        Input:
        s = "catsanddog"
        wordDict = ["cat", "cats", "and", "sand", "dog"]
        Output:
        [
          "cats and dog",
          "cat sand dog"
        ]
    */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= s.length();i++){
            for (int j = 0; j < i; j++){
                if (wordDict.contains(s.substring(j,i))){
                    if (map.containsKey(j)){
                        map.get(j).add(i);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        map.put(j,list);
                    }
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getAllIndex(lists,list,0,map,s.length());
        List<String> resList = new ArrayList<>();
        for (List<Integer> res :lists){
            String temp = s;
            for (int i = res.size()-2; i>=0;i--){
                temp = temp.substring(0,res.get(i))+ " " + temp.substring(res.get(i),temp.length());
            }
            resList.add(temp);
        }
        return resList;
    }
    void getAllIndex(List<List<Integer>> lists, List<Integer> list, int next,Map<Integer,List<Integer>> map,int end){
        if (map.containsKey(next)) {
            List<Integer> nextList = map.get(next);
            for (Integer n : nextList) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(n);
                if (n == end) {
                    lists.add(newList);
                } else {
                    getAllIndex(lists, newList, n, map, end);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        new WordBreak().wordBreak("catsandog",list);

    }
}
