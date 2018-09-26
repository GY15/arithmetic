package PAT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Translate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num[] = (scanner.nextLine().split(" "));
        String res = "";
        List<Integer> list = new ArrayList<>();
        boolean first = true;
        for (int i = 0; i < num.length ;i++){
            int m = Integer.parseInt(num[i]);
            if(first&&i!=0){
                if(m!=0){
                    res=i+res;
                    m--;
                    first=false;
                }
            }
            for (int j = 0;j<m;j++){
                res+=i;
            }

        }
        System.out.println(res);
    }
}
