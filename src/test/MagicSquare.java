package test;

import java.math.*;
import java.util.*;

/**
 * Created by 61990 on 2017/10/11.
 */
public class MagicSquare {
    static int num[][]={
            {8, 1, 6, 3, 5, 7, 4, 9, 2},
            {6, 1, 8, 7, 5, 3, 2, 9, 4},
            {4, 9, 2, 3, 5, 7, 8, 1, 6},
            {2, 9, 4, 7, 5, 3, 6, 1, 8},
            {8, 3, 4, 1, 5, 9, 6, 7, 2},
            {4, 3, 8, 9, 5, 1, 2, 7, 6},
            {6, 7, 2, 1, 5, 9, 8, 3, 4},
            {2, 7, 6, 9, 5, 1, 4, 3, 8}
    };
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int s []  = new int[9];
        for(int s_i=0; s_i < 9; s_i++){
                s[s_i] = in.nextInt();
        }
        int sum = -1;
        for (int i = 0; i < 8;i++){
            int n = getSubNum(i,s);
            if(sum == -1){
                sum =n;
            }
            else{
                sum= Math.min(sum,n);
            }
        }
        System.out.println(sum);

    }
    static int getSubNum(int n, int[] s){
        int temp = 0;
        for (int i = 0; i < 9;i++){
            temp += Math.abs(num[n][i]-s[i]);
        }
        return temp;
    }
}