package leetcode.middle.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap();
        for (int i = 0; i < strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sort = new String(chars);
            if (map.containsKey(sort)){
                List<String> s = map.get(sort);
                s.add(strs[i]);
            }else{
                List<String> s = new ArrayList<>();
                s.add(strs[i]);
                map.put(sort,s);
            }
        }
        List<List<String>> l = new ArrayList<>();
        for (String key : map.keySet()) {
            l.add(map.get(key));
        }
        return l;
    }
}
