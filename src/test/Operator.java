package test;

import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/3.
 */
public class Operator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();

        // Write your calculation code here.
        double tips =mealCost*tipPercent*1.0/100;
        double tax = mealCost * taxPercent *1.0 /100;
        double totalCost = mealCost + tips + tax ;


        // cast the result of the rounding operation to an int and save it as totalCost
        int totalCost1 = (int) Math.round(totalCost);

        // Print your result
//        System.out.println( Math.round(totalCost) );
        System.out.println("The total meal cost is "+ totalCost + " dollars.");
    }
}
