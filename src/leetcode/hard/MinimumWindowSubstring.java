package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {

    /*
    *
    * 最小子字符串包含t的字符
    *
    * 这个方法不太好，之后有机会去看一下leetcode大神解法
    *
    * */
    public static void main(String[] args) {
        new MinimumWindowSubstring().minWindow("ADOBECODEBANC"
                ,"ABCC");
    }


    public String minWindow(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, List<Integer>> map = new HashMap<>();
        int begin=-1;
        int end=-1;
        int numOfMulti = 0;
        int numOfChar = 0;
        for (int i = 0; i < t.length();i++){
            if (counter.get(t.charAt(i))!=null){
                counter.put(t.charAt(i),counter.get(t.charAt(i))+1);
                numOfMulti++;
            }else{
                counter.put(t.charAt(i),1);
                numOfChar++;
            }
        }
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if (counter.containsKey(c)) {
                if (map.get(c) != null) {
                    if (map.get(c).size() < counter.get(c)) {
                        map.get(c).add(i);
                        numOfMulti--;
                    } else {
                        map.get(c).remove(0);
                        map.get(c).add(i);
                    }
                } else {
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    map.put(c, temp);
                    numOfChar--;
                }
                if (numOfChar==0 && numOfMulti==0) {
                    int b=-1;
                    int e=-1;
                    for (char key : map.keySet()) {
                        List<Integer> temp = map.get(key);
                        if (b==-1){
                            b = temp.get(0);
                            e = temp.get(temp.size()-1);
                        }else {
                            if (temp.get(0) < b){
                                b= temp.get(0);
                            }
                            if (temp.get(temp.size()-1) > e){
                                e = temp.get(temp.size()-1);
                            }
                        }
                    }
                    if (begin == -1 || e  < end + b - begin) {
                        begin = b;
                        end = e;
                    }
                }
            }
        }
        if (end!=-1){
            return s.substring(begin,end+1);
        }
        return "";
    }
}
