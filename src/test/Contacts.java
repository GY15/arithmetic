package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/8.
 */
public class Contacts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> list = new ArrayList<>();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            int num=0;
            if(op.equals("add")){
                list.add(contact);
            }else {
                for (String s:list){
                    if(s.length()<contact.length()){
                        continue;
                    }else if(s.substring(0,contact.length()).equals(contact)){
                        num++;
                    }
                }
                System.out.println(num);
            }
        }
    }

}
