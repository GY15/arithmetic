package leetcode.easy;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <= n; i+=5){
            int temp = i;
            while(temp % 5 == 0 || temp % 10 ==0){
                if (temp % 5 == 0){
                    res++;
                    temp*=2;
                }else{
                    temp/=10;
                    res++;
                }
            }
        }
        return res;
    }
}
