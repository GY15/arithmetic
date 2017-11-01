package dynamic;

import java.util.Scanner;

/**
 * Created by 61990 on 2017/9/29.
 */
public class StringReduction {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named MagicSquare. */
        // Create a Scanner object to read input from stdin.
//        Scanner scan = new Scanner(System.in);
//        int inputString = scan.nextInt();
            int inputString =1;
        for (int i = 0;i < inputString; i++){
//            String string = scan.nextLine();
            String string = "ccbaccccbcccccbbccbaabaaabcabaabcbbcbccabccbcbacbcccbaccbabcabbcaa";
//            System.out.println(string);
//            String str = string;
//            String temp= "";
//            while(!string.equals(temp)){
//                temp = string;
//                string = delete(string);
//            }
            System.out.println(string);

            int num = getLength(string);
            System.out.println(num);
        }

//        scan.close();

    }

    private static int getLength(String string){
        int temp= 0;
        int num = string.length();
        for( int i = 0; i<string.length()-1; i++){
            String s = delete(string,i);
            if(s.length()<string.length()){
                temp = getLength(s);
            }else {
                temp = s.length();
            }
            if(temp<num){
                num = temp;
                if (num == 1||num==2){
                    break;
                }
            }
        }
        return num;
    }
    private static String delete(String str,int i){
            if(str.charAt(i) != str.charAt(i+1)){
               str = updateCharAt(str,i);
            }
        return str;
    }
    public static String updateCharAt(String s, int pos) {
        char replace = 'a';
        if(s.charAt(pos)=='a'&& s.charAt(pos+1)=='c'){
            replace='b';
        }else if(s.charAt(pos)=='c'&& s.charAt(pos+1)=='a'){
            replace='b';
        }else if(s.charAt(pos)=='a'&& s.charAt(pos+1)=='b'){
            replace='c';
        }else if(s.charAt(pos)=='b'&& s.charAt(pos+1)=='a'){
            replace='c';
        }else if(s.charAt(pos)=='b'&& s.charAt(pos+1)=='c'){
            replace='a';
        }else if(s.charAt(pos)=='c'&& s.charAt(pos+1)=='b'){
            replace='a';
        }
        return s.substring(0, pos) +replace + s.substring(pos + 2);
    }



}
