package medium;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//给出一组数，打印所有排列，不能有重复的数。
public class PaiLie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        for (int i = 0;i<n;i++){

        }
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(2);
        nums.add(5);
        Collections.sort(nums);
        array(new ArrayList<Integer>(),nums);
    }
    public static void array(List<Integer> printList,List<Integer> remind){
        if(remind.size()==0){
            myPrint(printList);
        }
        int operator = -1;
        for (int i = 0;i<remind.size();i++){
            if(operator!=remind.get(i)) {
                operator = remind.get(i);
                List<Integer> list = new ArrayList<>(remind);
                List<Integer> temp = new ArrayList<>(printList);
                list.remove(i);
                temp.add(operator);
                array(temp,list);
            }
        }
    }
    static void myPrint(List<Integer> list){
        for (int i =0 ;i< list.size();i++){
            System.out.print(list.get(i));
        }
        System.out.println();
    }
}
