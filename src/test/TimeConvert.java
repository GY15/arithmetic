package test;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/8.
 */
public class TimeConvert {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int max = 0;
        for(int i =0 ;i < 4;i++){
            for(int j=0; j < 4; j++){
                int temp = 0;
                temp= arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                max = Math.max(max,temp);
            }
        }
        System.out.print(max);
    }
}
//最大公约数
//         static public int gcd(int p,int q){
//            if(q == 0)    return p;
//            return gcd(q, p % q);
//        }

         //最小公倍数　
//         static public int lcm(int p,int q){
//            int pq = p * q;
//            return pq / gcd(p,q);
//        }
//    }
//
//        int a=0,b=0,c=0;
//        for (int i = 0; i <n ;i++){
//            int s= in.nextInt();
//            if(s>0){
//                a++;
//            }else if (s==0){
//                c++;
//            }else{
//                a++;
//            }
//        }
//        DecimalFormat df = new DecimalFormat("#.000000");
//        System.out.println(df.format(a*1.0/n));
//        System.out.println(df.format(b*1.0/n));
//        System.out.println(df.format(c*1.0/n));


