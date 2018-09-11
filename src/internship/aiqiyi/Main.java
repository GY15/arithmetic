package internship.aiqiyi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        delete(str,0);
    }
    public static void delete(String str,int n){
        if(n == str.length()){
            System.out.println(str);
            return;
        }
        char c = findNext(str,n);

        for (int i = n ; i < str.length();i++){

            if(str.charAt(i)<c){
                str = str.replaceAll(str.charAt(i)+"","");
                i=n-1;
            }else if(str.charAt(i)==c){
                delete(str,n+1);
                break;
            }
        }

    }
    public static char findNext(String str,int n){
        char nextChar = str.charAt(n);
        for (int i =n; i< str.length();i++){
            if(str.charAt(i)>nextChar){
                nextChar = str.charAt(i);
            }
        }
        return nextChar;
    }
}
