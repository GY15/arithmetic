package internship.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class magicWeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        K = scanner.nextInt();
        scanner.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine().trim());
        }
        allSort(list,"");
        System.out.println(num);
    }
    static int num =0;
    static int K =0;
    private static void allSort(List<String> list,String string){
        if (list.size()==0){
            if (K==calculateWeight(string)){
                num++;
            }
        }
        for (int i = 0; i<list.size();i++){
                List<String> tempList = new ArrayList<>(list);
            tempList.remove(i);
                String tempString = string;
               allSort(tempList,tempString+=list.get(i));
        }
    }
    public static int calculateWeight(String s){
        String temp = s;
        int weight =0;
        for (int i = 0; i< s.length();i++){
            temp = temp.substring(1,temp.length())+temp.substring(0,1);
            if(temp.equals(s)) {
                weight++;
            }
        }
        return weight;
    }
}
