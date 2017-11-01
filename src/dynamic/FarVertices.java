package dynamic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 61990 on 2017/9/30.
 */
public class FarVertices {
    static ArrayList<Integer> list1;
    static ArrayList<Integer> list2;
    public static void main(String[] args) {

//        Scanner scan = new Scanner(System.in);
//        int len = scan.nextInt();
//        int maxPath = scan.nextInt();
        int len = 7;
        int maxPath = 3;
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
//        for (int i = 0; i < len-1; i++){
//            int num1 = scan.nextInt();
//            list1.add(num1);
//            int num2 = scan.nextInt();
//            list2.add(num2);
//        }
//        scan.close();
       list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(5);
        list1.add(6);
       list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);

        int maxVertices = 0;
        if( maxPath % 2 == 0){
            //以一个为中心，计算的子代为 maxPath/2 代
            for(int i =1;i <= len; i++){
               maxVertices = Math.max(calculateChild( i,maxPath/2, 0 ),maxVertices);
            }
        }else{
            if(maxPath==1){
                maxVertices = 2;
            }else {
                int num1, num2, total = 0;
                //以两个点为中心，计算的子代为 maxPath/2代11
                for (int i = 0; i < list1.size(); i++) {
                    num1 = list1.get(i);
                    num2 = list2.get(i);
                    maxVertices = Math.max(calculateChild(num1, maxPath / 2, num2) + calculateChild(num2, maxPath / 2, num1) , maxVertices);
                }
            }
        }


        System.out.println(len-maxVertices);

    }

    private static int calculateChild(int num, int path, int mom){
        int temp = 1;
        if(path == 0){
            return temp+0;
        }
        else {
            for (int i = 0; i < list1.size() ; i++ ){
                if(list1.get(i)== num && list2.get(i) != mom){
                    temp = temp + calculateChild(list2.get(i),path-1,num);
                }
                if(list2.get(i)== num && list1.get(i) != mom){
                    temp = temp + calculateChild(list1.get(i),path-1,num);
                }
            }
            return temp;
        }
    }

}
