package internship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            num1.add(scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            num2.add(scanner.nextInt());
        }
        calculate(num1, num2, 0);
        System.out.println(total);
    }

    static int total = 0;

    static void calculate(List<Integer> list1, List<Integer> list2, int num) {
        if (total == 0) {
            total = num;
        } else {
            total = Math.max(total, num);
        }
        handle(list1,list2,num);
        handle(list2,list1,num);
    }
    static void handle(List<Integer> list1,List<Integer> list2,int num){
        double ave1 = average(list1);
        double ave2 = average(list2);
        for (int i = 0; i < list2.size(); i++) {
            List<Integer> templist1 = new ArrayList<>(list1);
            List<Integer> templist2 = new ArrayList<>(list2);
            if (templist2.get(i) < ave2) {
                templist1.add(templist2.get(i));
                templist2.remove(i);
                if(templist2.size()==0){

                }else if (average(templist1) > ave1) {
                    calculate(templist2, templist1, num + 1);
                    calculate(templist1, templist2, num + 1);
                }
            }
        }
    }
    static double average(List<Integer> num) {
        int sum = 0;
        for (int i = 0; i < num.size(); i++) {
            sum += num.get(i);
        }
        return sum * 1.0 / num.size();
    }
}
