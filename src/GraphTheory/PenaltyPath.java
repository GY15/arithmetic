package GraphTheory;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/3.
 */
public class PenaltyPath {
    private static List<Integer> list1,list2,list3;
    static boolean havePass[];

    static int pathValve[];
    static int pre[];

    static int end = 0;
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int nodes = scan.nextInt();
        int edges = scan.nextInt();
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            int num3 = scan.nextInt();
            list1.add(num1);
            list2.add(num2);
            list3.add(num3);
        }
        int start = scan.nextInt();
        int end = scan.nextInt();
        scan.close();

        havePass = new boolean[nodes + 1];
        pathValve = new int[nodes + 1];
        pre = new int[nodes + 1];

        pre[start] = 0;
        havePass[0] = true;
        havePass[start]=true;
        int size = list1.size()-1;
        while (list1.size() != 0) {

            List<Integer> existNodes = getExistedNodes();
            for (int i = 0; i < list1.size(); i++) {
                if (list1.size() == 0) {
                    break;
                }
                if (list1.get(i) == list2.get(i)) {
                    list1.remove(i);
                    list2.remove(i);
                    list3.remove(i);
                    i--;
                } else {
                    if ((in(existNodes, list1.get(i)))) {
                        if (pathValve[list2.get(i)] == 0) {
                            pathValve[list2.get(i)] = list3.get(i) + pathValve[list1.get(i)];
                            pre[list2.get(i)] = list1.get(i);
                        } else {
                            if (pathValve[list2.get(i)] > list3.get(i) + pathValve[list1.get(i)]) {
                                pathValve[list2.get(i)] = list3.get(i) + pathValve[list1.get(i)];
                                pre[list2.get(i)] = list1.get(i);
                            }
                        }
                        havePass[list2.get(i)] = true;
                        list1.remove(i);
                        list2.remove(i);
                        list3.remove(i);
                        i--;
                    } else if ((in(existNodes, list2.get(i)))) {
                        if (pathValve[list1.get(i)] == 0) {
                            pathValve[list1.get(i)] = list3.get(i) + pathValve[list2.get(i)];
                            pre[list1.get(i)] = list2.get(i);
                        } else {
                            if (i == 0) {

                            }
                            if (pathValve[list1.get(i)] > list3.get(i) + pathValve[list2.get(i)]) {
                                pathValve[list1.get(i)] = list3.get(i) + pathValve[list2.get(i)];
                                pre[list1.get(i)] = list2.get(i);
                            }
                        }
                        havePass[list1.get(i)] = true;
                        list1.remove(i);
                        list2.remove(i);
                        list3.remove(i);
                        i--;
                    }
                }
            }
            size = list1.size();
        }

        long lis=0;
        while(pre[end]!=0){
            lis= lis|(pathValve[end] - pathValve[pre[end]]);
            end = pre[end];
        }
        System.out.println(lis);
    }
    public static List<Integer> getExistedNodes(){
        List<Integer> list = new ArrayList<>();
        for (int i = 1 ;i <havePass.length;i++){
            if (havePass[i]){
                list.add(i);
            }
        }
        return list;
    }
    public static boolean in(List<Integer> l, int num){
        for (int i = 0; i<l.size(); i++){
            if (l.get(i)==num){
                return true;
            }
        }
        return false;
    }

}
