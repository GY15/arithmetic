package leetcode.middle.number;

public class divide {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean greaterThan0 = (dividend < 0) == (divisor < 0);
        dividend = dividend > 0? -dividend: dividend;
        divisor = divisor > 0? -divisor: divisor;
        int res = divideHelper(dividend, divisor);
        return greaterThan0? res: -res;
    }

    public int divideHelper(int dividend, int divisor){
        if(divisor < dividend) return 0;
        int sum = divisor, m = 1;
        while((Integer.MIN_VALUE - sum < sum) && (sum + sum > dividend)){
            sum += sum;
            m += m;
        }
        return m + divideHelper(dividend - sum, divisor);
    }
}
