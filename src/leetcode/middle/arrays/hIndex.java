package leetcode.middle.arrays;

import java.util.Arrays;
import java.util.Collections;

public class hIndex {
    //274
    public static void main(String[] args) {
        System.out.println(new hIndex().hIndex(new int[]{41,1,1,1,2}));
    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length-1,j = 1;i >= 0;i--,j++){
            if(j > citations[i]){
                return j-1;
            }
        }
        return citations.length;
    }
}
