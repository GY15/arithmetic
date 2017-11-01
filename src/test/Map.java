package test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/7.
 */
public class Map {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            map.put(name,phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if(map.get(s)!=null) {
                System.out.println(s + "=" + map.get(s));
            }else{
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
//2 8 1 2 3 4 1 2 3 5 2 1 2
