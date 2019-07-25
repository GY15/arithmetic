package leetcode.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        Map<Character,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if (!map.containsKey(c)){
                List<Integer> list = new ArrayList<>();
                map.put(c,list);
            }
        }
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.get(c).add(i);
            }
        }
        return matchNext(map,t,0,0);
    }
    public int matchNext(Map<Character,List<Integer>> map ,String t, int index,int cur){
        List<Integer> list = map.get(t.charAt(index));
        if (list.size() == 0 || list.get(list.size()-1) < cur){
            return 0;
        }
        int res = 0;
        if (index == t.length()-1){
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) >= cur) {
                    res++;
                }
            }
        }else {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) < cur) {
                    break;
                }
                res += matchNext(map, t, index + 1, list.get(i) + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = (line);
            line = in.readLine();
            String t = (line);

            int ret = new DistinctSubsequences().numDistinct(s, t);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
