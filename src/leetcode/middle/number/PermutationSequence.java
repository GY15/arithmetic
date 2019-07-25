package leetcode.middle.number;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    /*
    * The set [1,2,3,...,n] contains a total of n! unique permutations.

        By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

        n个数字排列组合的第i个值是多少

·       先找规律，通过现在(n-1)！和当前的k可以计算出当前数字为多少
    * */
    public static void main(String[] args) {
        new PermutationSequence().getPermutation(4,7);
    }
    public String getPermutation(int n, int k) {
        if (n==1&& k==1){
            return "1";
        }
        int total =1 ;
        List<Integer> number = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            number.add(i);
        }
        int i;
        for (i = 2; i < n; i++){
            total*=i;
        }
        i--;
        StringBuffer s = new StringBuffer();

        while (k!=0){
            int num = (k-1)/total;
            s.append(number.get(num));
            number.remove(num);
            k -= (num)*total;
            if (i==0){
                break;
            }
            total/=i;
            i--;
        }

        return s.toString();
    }
}
/*
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
*/
