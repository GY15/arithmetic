package leetcode.middle.number;

import java.util.Arrays;

public class integerBreak {
    public static void main(String[] args) {
        new integerBreak().integerBreak(3);
    }
    public int integerBreak(int n) {
        int min = (int) Math.pow(n,0.5);
        int num = min;
        if(min*min < n){
            min++;
        }
        int res= 1;
        while(n != 0){
            res *= min;
            n -= min;
            num--;
            if (num > 0)
                min = n/num;
        }
        return res;
    }
    public void reverseString(char[] s) {
        for (int i = 0,j=s.length-1;i < j; i++,j--){
            s[i] += s[j];
            s[j] = (char) (s[i] -s[j]);
            s[i] -=s[j];
        }
    }

}
