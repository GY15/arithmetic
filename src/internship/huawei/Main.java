package internship.huawei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        if(str.length()==1){
            System.out.println(1);
        }else if(str.length()==2){
            System.out.println(str.charAt(1)==str.charAt(0)?2:1);
        }else {
            for (int i = 0; i < str.length() - 1; i++) {
                expend(i - 1, i + 1, str);
                if(str.charAt(i)==str.charAt(i+1)){
                    expend(i - 1, i + 2, str);
                }
            }
            System.out.println(maxLength);
        }
    }
    static int maxLength = 1;
    static void expend(int pre,int post,String str){
        if(pre < 0||post>=str.length()){
            maxLength = Math.max(post-pre-1,maxLength);
        }
        else{
            if(str.charAt(pre)==str.charAt(post)){
                expend(pre-1,post+1,str);
            }else{
                maxLength = Math.max(post-pre-1,maxLength);
            }
        }
    }
}
