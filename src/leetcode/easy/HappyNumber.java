package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        int next = 0;
        while(n!=0){
            next += Math.pow(n%10,2);
            n/=10;
        }
        if (next == 1){
            return true;
        }else{
            if (set.add(next)){
                return isHappy(next);
            }else{
                return false;
            }
        }
    }
}
