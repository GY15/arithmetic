package oj;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        long n = new Solution().GCD(20,15);
        long m = new Solution().GCD(15,20);
        new Solution().fraction(new int[]{2,1,-1,1});
    }

    public int[] fraction(int[] cont) {
        long fenzi = 1;
        int index= cont.length-1;
        long fenmu = cont[index--];
        if(fenmu < 0){
            fenzi = - 1;
            fenmu = - fenmu;
        }
        long gcd = 1;
        while(index >= 0) {
            if(fenmu == 0){
                return new int[]{0,0};
            }
            fenzi = cont[index--] * fenmu + fenzi;
            gcd = GCD(Math.abs(fenzi),Math.abs(fenmu));
            fenzi/=gcd;
            fenmu/=gcd;
            if(fenzi <= 0 && fenmu < 0){
                fenzi = -fenzi;
                fenmu = -fenmu;
            } else if (fenzi >= 0 && fenmu < 0){
                fenmu = -fenmu;
                fenzi = -fenzi;
            }
            if(index >= 0){
                long temp =fenzi;
                fenzi = fenmu;
                fenmu = temp;
            }
        }

        return new int[]{(int)fenzi,(int)fenmu};

    }

    public long GCD(long m, long n) {
        long result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

}
