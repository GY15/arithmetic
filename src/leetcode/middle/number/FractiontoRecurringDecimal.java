package leetcode.middle.number;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        return fractionToDecimal(numerator,denominator,false);
    }
    public String fractionToDecimal(long numerator, long denominator,boolean f) {
        String sign = "";
        if (numerator * denominator < 0){
            sign += "-";
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long integer = numerator/denominator;
        long left = numerator - integer * denominator;
        if (left==0){
            return sign + String.valueOf(integer);
        }
        StringBuilder decimal = new StringBuilder();
        List<Long> lefts = new ArrayList<>();

        while(true){
            left*=10;
            long next = left / denominator;
            left = left - next * denominator;
            if (left == 0){
                decimal.append(next);
                return sign + integer+"."+decimal.toString();
            }
            if (lefts.contains(left)){

                decimal.append(next);
                break;
//                lefts.add(left);
//                if (left==1000){
//                    return "1";
//                }
            }else{
                lefts.add(left);
            }
            decimal.append(next);
        }

        decimal.append(")");
        return sign+integer+"."+decimal.insert(lefts.indexOf(left)+1,"(").toString();
    }

    public static void main(String[] args) {
        System.out.println ( new FractiontoRecurringDecimal().fractionToDecimal(1,2));
    }
}
