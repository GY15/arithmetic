package oj;

import java.util.Scanner;

public class add1001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int f = 0; f < n; f++){
            if (f!=0){
                System.out.println();
            }
            int n1 = scanner.nextInt();
            int sum = 0;
            for (int i = 0; i < n1;i++){
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }
    }
}
