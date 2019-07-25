package leetcode.middle.trans;

import java.util.PriorityQueue;
import java.util.Queue;

public class DecodeWays {
    //A message containing letters from A-Z is being encoded to numbers using the following mapping:
    //
    //'A' -> 1
    //'B' -> 2
    //...
    //'Z' -> 26
    //Given a non-empty string containing only digits, determine the total number of ways to decode it.
    //
    //Example 1:
    //
    //Input: "12"
    //Output: 2
    //Explanation: It could be decoded as "AB" (1 2) or "L" (12).

    //我的算法时间和空间复杂度都很优秀，可以看一下被人的解法
    public static void main(String[] args) {
        new DecodeWays().numDecodings("12");
    }
    public int numDecodings(String s) {
        Queue<Integer> queue =new PriorityQueue<>();
        int res= 0;
        boolean lastIsOne = false;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (res==0){
                    return 0;
                }
                if (res > 2) {
                    queue.add(res - 1);
                }
                res = 0;
                lastIsOne = false;
            } else if (s.charAt(i) == '1') {
                res++;
                lastIsOne = true;
            } else if (s.charAt(i) == '2') {
                res++;
                lastIsOne = false;
            }else if ( s.charAt(i) >='3' && s.charAt(i) <='6') {
                if (res > 0) {
                    queue.add(res+1);
                }
                res = 0;
                lastIsOne = false;
            }else {
                if (lastIsOne){
                    if (res >= 1) {
                        queue.add(res+1);
                    }
                    res = 0;
                } else {
                    if (res > 1) {
                        queue.add(res);
                    }
                    res = 0;
                }
            }
        }
        if (res> 1){
            queue.add(res);
        }
        res = 1;
        int num1 = 1;
        int num2 = 2;
        int i = 2;
        while (queue.size()!=0){
            if (queue.peek() == 2){
                res *= queue.poll();
            } else {
                if (i == queue.peek()) {
                    res *= num2;
                    queue.poll();
                } else {
                    i++;
                    int temp = num1 + num2;
                    num1 = num2;
                    num2 = temp;
                }
            }
        }
        return res;
    }
    public class Solution {
        public int numDecodings(String s) {
            if(s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = s.charAt(0) != '0' ? 1 : 0;
            for(int i = 2; i <= n; i++) {
                int first = Integer.valueOf(s.substring(i-1, i));
                int second = Integer.valueOf(s.substring(i-2, i));
                if(first >= 1 && first <= 9) {
                    dp[i] += dp[i-1];
                }
                if(second >= 10 && second <= 26) {
                    dp[i] += dp[i-2];
                }
            }
            return dp[n];
        }
    }
}
