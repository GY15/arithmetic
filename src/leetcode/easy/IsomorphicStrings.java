package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c1= s.charAt(i);
            char c2= t.charAt(i);
            if ((map.containsKey(c1) && map.get(c1) != c2) || (map2.containsKey(c2) && map2.get(c2) != c1)){
                return false;
            }else{
                map.put(c1,c2);
                map2.put(c2,c1);
            }
        }
        return true;
    }
}
