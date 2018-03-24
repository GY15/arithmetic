package Exam;

import java.util.Scanner;

public class AddOr {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int k = scanner.nextInt();
        String baseNum = intToString(x);
        String bonus = intToString(k);
        int bonusIndex = bonus.length()-1;
        for (int i = baseNum.length();i > 0;i--){
            if(baseNum.charAt(i-1)=='0'){
                baseNum = baseNum.substring(0, i - 1) + bonus.charAt(bonusIndex) + baseNum.substring(i,baseNum.length());
                bonusIndex--;
            }
        }
        System.out.println(stringToInt(baseNum)-x);

    }

    private static String intToString(long num){
        String res = "";
        for(int i = 31; i>=0;i--){
            long temp =1;
            for (int j = 0; j < i;j++){
                temp *=2;
            }
            res += num/temp;
            num-=(num/temp)*temp;
        }
        return res;
    }
    private static long stringToInt(String num){
        long result =0;
        long base = 1;
        for (int i = num.length()-1 ; i>=0;i--){
            result += Integer.parseInt(num.charAt(i)+"")*base;
            base*=2;
        }
        return result;
    }
}
