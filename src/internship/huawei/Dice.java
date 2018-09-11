package internship.huawei;

import java.util.*;

public class Dice {
    static TreeMap<Integer,Integer> map;
//
//    public static void main(String[] args) {
//        int n = 25;
//        Stack<Double> stack = new Stack<>();
//        double all = Math.pow(6,n);
//        for (int i = n;i <= n*7/2;i++){
//            LinkedList<Integer> list = new LinkedList<>();
//            sum = 0;
//            createListToTarget(n,i,list);
//            stack.push(sum * 1.0/all);
////            System.out.println(sum * 1.0/all);
//            sum=0;
//        }
//        if (n*7%2==0){
//            stack.pop();
//        }
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
//    }
//    static int sum ;
//    public static void createListToTarget(int n, int target, LinkedList<Integer> list){
//        int max;
//        if (list.size()!=0) {
//            max = list.getLast();
//        }else{
//            max = 1;
//        }
//        if (n==0){
//            double res = 1.0 * recursion(list.size());
//            int repeat = 1;
//            for (int i = 0; i < list.size()-1;i++){
//                if(list.get(i)==list.get(i+1)){
//                    repeat++;
//                }else{
//                    repeat=1;
//                }
//                res/=repeat;
//            }
//            sum+=res;
//            return;
//        }
//        n = n-1;
//        for (int i = max; i <= 6;i++){
//            if(target-i > n*6){
//                continue;
//            }else if(target-i < n*i){
//                break;
//            }else {
//                LinkedList<Integer> newList = new LinkedList<>(list);
//                newList.add(i);
//                createListToTarget(n,target-i,newList);
//            }
//
//        }
//    }
//    public static int recursion(int num){//利用递归计算阶乘
//        int sum=1;
//        if(num < 0)
//            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常
//        if(num==1){
//            return 1;//根据条件,跳出循环
//        }else{
//            sum=num * recursion(num-1);//运用递归计算
//            return sum;
//        }
//    }
    public static void main(String[] args) {
        int n = 13;
        map= new TreeMap<>();
        for (int i = n ; i <= 6*n ; i++){
            map.put(i,0);
        }
        throwOne(n,0);
        double all = Math.pow(6,n);
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(map.get(it.next())*1.0/all);
        }
    }
    static void throwOne(int n,int sum){
        if(n==0){
            map.put(sum,map.get(sum)+1);
        }else{
            for (int i = 1;i<=6;i++){
                throwOne(n-1,i+sum);
            }
        }
    }

}
