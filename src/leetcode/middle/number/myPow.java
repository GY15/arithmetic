package leetcode.middle.number;

import java.math.BigDecimal;

public class myPow {
    public static void main(String[] args) {
        new myPow().myPow(2,10);
    }
    public double myPow(double x, int n) {
        boolean is = n>0;
        n=Math.abs(n);
        BigDecimal xx = new BigDecimal(x);
        BigDecimal total = new BigDecimal(1);
        for (int i = 0;i < n;i++){
            total = total.multiply(xx);
        }
        if (is){
            return total.doubleValue();
        }else{
            return (new BigDecimal(1.0).divide(total)).doubleValue();
        }
    }
}
