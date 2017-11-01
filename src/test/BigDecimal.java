package test;

import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/11.
 */
public class BigDecimal {

//    public static void main(String[] args) {
//              /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named MagicSquare. */
//        Scanner scan = new Scanner(System.in);
//        long n = scan.nextLong();
//        long num = 1;
//        long multi = 0;
//        long multi2 = 0;
//        for (long i = 1; i <= n; i++) {
//            num *= i;
//            multi *= i;
//            multi2 *= i;
//            if (num > Math.pow(10, 17)) {
//                multi += num / Math.pow(10, 17);
//                num %= Math.pow(10, 17);
//            }
//            if (multi > Math.pow(10, 17)) {
//                multi2 += multi / Math.pow(10, 17);
//                multi %= Math.pow(10, 17);
//            }
//        }
//        if(multi == multi2){
//            System.out.println(num);
//        }
//        if(multi2!=0){
//            String n1=multi+"";
//            String m=num+"";
//
//            for (int i = (int)(multi+"".length());i<17;i++){
//                n1="0"+n1;
//            }
//            for (int i = (int)(num+"".length());i<17;i++){
//                m="0"+m;
//            }
//            System.out.println(multi2+""+n1+""+m);
//        }else{
//            if(multi!=0){
//                String m=num+"";
//                for (int i = (int)(num+"".length());i<17;i++){
//                    m="0"+m;
//                }
//                System.out.println(multi+""+m);
//            }
//        }
//    }

    public static void main(String[] args) {
        int s1;
        Scanner cin = new Scanner(System.in);
        s1 = cin.nextInt();
        java.math.BigDecimal b1 = new java.math.BigDecimal("1");
        for (int i = 1; i<=s1 ;i++){
            b1=b1.multiply(new java.math.BigDecimal(i+""));
        }
        System.out.println(b1);
        cin.close();

    }
}


