package internship.huawei;

import java.util.LinkedList;
import java.util.Stack;

public class Dice2 {
    //
    public static void main(String[] args) {
        int n = 13;
        Stack<Double> stack = new Stack<>();
        double all = Math.pow(6,n);
        long s = 0;
        for (int i = n;i <= n*6;i++){
            LinkedList<Integer> list = new LinkedList<>();
            sum = 0;
            createListToTarget(n,i,list);
            s+=sum;
//            System.out.println(sum * 1.0/all);
            sum=0;
        }
        System.out.println(all);
        System.out.println(s);
        if (n*7%2==0){
            stack.pop();
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    static int sum ;
    public static void createListToTarget(int n, int target, LinkedList<Integer> list){
        int max;
        if (list.size()!=0) {
            max = list.getLast();
        }else{
            max = 1;
        }
        if (n==0){
            double res = 1.0 * recursion(list.size());
            int repeat = 1;
            for (int i = 0; i < list.size()-1;i++){
                if(list.get(i)==list.get(i+1)){
                    repeat++;
                }else{
                    repeat=1;
                }
                res/=repeat;
            }
            sum+=res;
            return;
        }
        n = n-1;
        for (int i = max; i <= 6;i++){
            if(target-i > n*6){
                continue;
            }else if(target-i < n*i){
                break;
            }else {
                LinkedList<Integer> newList = new LinkedList<>(list);
                newList.add(i);
                createListToTarget(n,target-i,newList);
            }

        }
    }
    public static int recursion(int num){//利用递归计算阶乘
        int sum=1;
        if(num < 0)
            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常
        if(num==1){
            return 1;//根据条件,跳出循环
        }else{
            sum=num * recursion(num-1);//运用递归计算
            return sum;
        }
    }
}
