package PAT;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();

        char c;
        int p=0, pa=0, pat=0;

        // 统计
        for (int i =0;i<str.length();i++) {
            c= str.charAt(i);
            if(c == 'P') {
                p++;
            } else if(c == 'A') {
                pa += p;
                pa = pa%1000000007;
            } else {
                pat += pa;
                pat = pat%1000000007;
            }
        }
        System.out.println(pat);

    }
}

