package Exam;

import java.lang.reflect.Array;
import java.util.*;

public class Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Long> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int operation = scanner.nextInt();
            long length = scanner.nextLong();
            if(operation==1){
                resultList = insert(resultList,length);
            }else{
                resultList = remove(resultList,length);
            }
            System.out.println(judge(resultList)?"yes":"no");
        }
    }

    private static List<Long> insert(List<Long> list,long num){
        if (list.size()==0){
            list.add(num);
        }
        else if(list.get(list.size()-1) > num){
            list.add(num);
        }else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= num) {
                    list.add(i, num);
                    break;
                }
            }
        }
        return list;
    }
    private static List<Long> remove(List<Long> list,long num){

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == num) {
                    list.remove(i);
                    return list;
                }
        }
        return null;
    }
    private static boolean judge(List<Long> list){
        if (list.size()<=2){
            return false;
        }else{
            long sum = 0;
            for (int i=1;i<list.size();i++){
                  sum+=list.get(i);
            }
            if(sum <= list.get(0)){
                return false;
            }else {
                return true;
            }

        }
    }
}
