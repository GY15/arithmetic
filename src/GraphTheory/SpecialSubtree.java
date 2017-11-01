package GraphTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 61990 on 2017/10/1.
 */
public class SpecialSubtree {
    private static List<Integer> list1,list2,list3;
    static int number[];
    static int path=0;

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int nodes = scan.nextInt();
        int edges = scan.nextInt();
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        for (int i = 0; i < edges; i++){
            int num1 = scan.nextInt();
            list1.add(num1);
            int num2 = scan.nextInt();
            list2.add(num2);
            int num3 = scan.nextInt();
            list3.add(num3);
        }
        int start = scan.nextInt();
        scan.close();

        number = new int[nodes+1];

        number[start] = 1;


        number[0]=1;


        while (getExistedNodes().size()!= nodes ){
            List<Integer> existNodes = getExistedNodes();
            getSmallest(existNodes);
        }

        System.out.println(path);


    }

    public static List<Integer> getExistedNodes(){
        List<Integer> list = new ArrayList<>();
        for (int i = 1 ;i < number.length;i++){
            if (number[i]!=0){
                list.add(i);
            }
        }
        return list;
    }
    public static void getSmallest(List<Integer> nodes){
        int minNode1= 0,minNode2= 0, minPath = 0;
        for(int i = 0 ; i < list1.size(); i++){
            if ((in(nodes,list1.get(i))&&(!in(nodes,list2.get(i))))  || (in(nodes,list2.get(i))&&(!in(nodes,list1.get(i))))  ){
                if (minPath==0){
                    minNode1 = list1.get(i);
                    minNode2 = list2.get(i);
                    minPath = list3.get(i);
                }else{
                    if(minPath > list3.get(i)){
                        minPath = list3.get(i);
                        minNode1 = list1.get(i);
                        minNode2 = list2.get(i);
                    }
                }
            }
        }
        path+=minPath;
        addNodes(minNode1,minNode2);
    }

    public static boolean in(List<Integer> l, int num){
        for (int i = 0; i<l.size(); i++){
            if (l.get(i)==num){
                return true;
            }
        }
        return false;
    }

    public static void  addNodes( int node1,int node2){
        number[node1] = 1;
        number[node2] = 1;
    }

}
