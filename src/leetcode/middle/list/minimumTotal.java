package leetcode.middle.list;

import java.util.Collections;
import java.util.List;

class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return 0;
        }else if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        for(int i = 1;i < triangle.size();i++){
            List<Integer> list = triangle.get(i);
            for(int j = 0; j < list.size();j++){
                if(j==0){
                    list.set(0, list.get(0)+ triangle.get(i-1).get(0));
                }else if(j == list.size()-1){
                    list.set(j,list.get(j)+triangle.get(i-1).get(j-1));
                }else{
                    list.set(j, list.get(j)+Math.max(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)));
                }
            }
            if(i==triangle.size()-1){
                Collections.sort(list);
                return list.get(list.size()-1);
            }
        }
        return 0;
    }
}

