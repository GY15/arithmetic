package interview.alibaba;

import java.sql.Timestamp;

public class sqrt {
    /*
    题目：已知 sqrt (2)约等于 1.414，要求不用数学库，求 sqrt (2)精确到小数点后 10 位。
    * */
    public String sqrt(int n){
        long start = System.currentTimeMillis();
        long left = 2;
        long cur = 0;
        StringBuilder decimal = new StringBuilder();
        for(int i = 0; i<=220;i++){
            for (int j = 1; j <= 10;j++){
                if((j)*(j) + (j)*cur *10 *2 > left){
                    decimal.append(j-1);
                    if (i == 0){
                        decimal.append(".");
                    }
                    left-=(j-1)*(j-1) + (j-1)*cur *10 *2;
                    cur = (cur*10 +j-1);
                    left*=100;
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return decimal.toString();
    }

    public static void main(String[] args) {
        System.out.println(new sqrt().sqrt(2));
    }
}
