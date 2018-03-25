package internship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        int result = 0;
        if (k==0){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                insert(list, num);
            }
            System.out.println(list.size());
        }else {
            for (int i = 0; i < k; i++) {
                List<Integer> list = new ArrayList<>();
                lists.add(list);
            }
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                insert(lists.get(num % k), num);
            }
            for (int i = 0; i < k; i++) {
                List<Integer> temp = lists.get(i);
                result += calculate(temp, k);
            }
            System.out.println(result);
        }
    }

    private static int calculate(List<Integer> list,int k){
        int sum =0;
        if (list.size()==0){
            return 0;
        }else{
            for (int i = 1; i< list.size();i++){
                if(Math.abs(list.get(i)-list.get(i-1))==k){
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void insert(List<Integer> list,int num){
        if (list.size()==0){
            list.add(num);
        }
        else if(list.get(list.size()-1) > num){
            list.add(num);
        }else {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)==num){
                    break;
                }else if (list.get(i) < num) {
                    list.add(i, num);
                    break;
                }
            }
        }
    }
}
