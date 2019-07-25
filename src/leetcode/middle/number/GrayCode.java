package leetcode.middle.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        if(n == 0) return Arrays.asList(0);
        List<Integer> prev = grayCode(n-1);
        List<Integer> next = new ArrayList<Integer>(prev);
        int pow = 1 << (n-1);
        for(int i=prev.size()-1; i >= 0; i--){
            next.add(prev.get(i) | pow);
        }
        return next;
    }

    public static void main(String[] args) {
        new GrayCode().grayCode(4);
    }
}
