package oj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String s1 = scanner.nextLine();
            String[] arr = s1.split(" ");
            Integer sum = 0;
            for (int j = 1; j <= Integer.valueOf(arr[0]); j++) {
                sum = sum + Integer.valueOf(arr[j]);
            }
            if (sum != 0)
                sums.add(sum);
        }
        int count=0;
        for (Integer sum : sums) {
            count++;
            if (count == sums.size())
            {
                System.out.print(sum);
            }
            else
                System.out.println(sum);
        }
    }
}