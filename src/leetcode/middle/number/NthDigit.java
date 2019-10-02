package leetcode.middle.number;

public class NthDigit {
    public static void main(String[] args) {
        new NthDigit().findNthDigit(100);
    }
    public int findNthDigit(int n) {
        long n1 = n;
        if(n1 < 10){
            return n;
        }
        long count = 1;
        long times = 1;
        while(n > count * 9 * times){
            n1 -= count * 9 * times;
            count ++;
            times *= 10;
        }
        times = (n1 - 1) / count + times;
        n  = (int) ((n1 - 1) % count);
        return String.valueOf(times).charAt(n) - '0';
    }
}
