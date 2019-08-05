package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class maxPoints {
    //149
    public static void main(String[] args) {
        new maxPoints().maxPoints(new int[][]{{4,0},{4,7},{4,-1}});
    }
    public int maxPoints(int[][] points) {
        if(points.length==0|| points.length==1){
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length;i++){
            Map<Double,List<int[]>> map = new HashMap<>();
            int extra = 0;
            int max = 1;
            for (int j = i+1;j < points.length;j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                double xDy;
                if (y == 0){
                    if (x == 0){
                        extra++;
                        continue;
                    }
                    xDy = 1;
                }else if (x==0){
                   xDy = 0;
                }else{
                    xDy = x*1.0/y;
                }

                if (map.containsKey(xDy)){
                    map.get(xDy).add(points[j]);
                }else{
                    map.put(xDy,new ArrayList<int[]>());
                    map.get(xDy).add(points[i]);
                    map.get(xDy).add(points[j]);
                    max= Math.max(max,map.get(xDy).size());
                }
            }
            res = Math.max(max+extra,res);

        }
        return res;
    }
}
