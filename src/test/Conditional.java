package test;

import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/3.
 */
public class Conditional {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        String ans="";

        // if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
        if(n%2==1){
            ans = "Weird";
        }
        else{
            if(n<=5&&n>=2){
                ans = "Nor Weird";
            }else if(n>=6 && n<=20){
                ans = "Weird";
            }else if(n> 20){
                ans = "Weird";
            }
        }
        System.out.println(ans);
    }
}
