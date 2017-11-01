package test;

import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/11.
 */
public class GrowTree {
    public static void main(String[] args) {
        java.math.BigDecimal height=new java.math.BigDecimal("1");
        boolean isSpring = true;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num[]= new int[n];
        String highs[] =  new String[60];
        for (int i = 0; i< n ;i++ ){
            num[i] = in.nextInt();
        }
        for(int i = 0; i<60;i++){
            highs[i] = height.toString();

            if(isSpring) {
                height = height.multiply(new java.math.BigDecimal("2"));
                isSpring=false;

            }else{
                isSpring=true;
                height = height.add(new java.math.BigDecimal("1"));

            }
        }
        for (int i=0; i < n; i++){
            System.out.println(highs[num[i]]);
        }

    }
}

