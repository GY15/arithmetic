package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/19.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int length = str.length();
        int rows = (int)Math.pow(length,0.5);
        int cols;
        if(rows*rows==length){
            cols=rows;
        }else if(rows*(rows+1)==length){
            cols=rows+1;
        }else if(rows*(rows+1)>length) {
            cols = rows + 1;
        }else{
            cols = rows+1;
            rows=rows+1;
        }
        for(int i =0 ;i<cols;i++){
            for (int j = 0;j<rows;j++){
                if((i+j*cols) < length){
                    System.out.print(str.charAt(i+j*cols));
                }
            }
            System.out.print(" ");
        }
    }
}