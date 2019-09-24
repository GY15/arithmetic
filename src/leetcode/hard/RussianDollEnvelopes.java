package leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static void main(String[] args) {

    }
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[]dp = new int[envelopes.length];
        dp[0] = 1;
        int res = 0;
        for (int i = 1;i < envelopes.length;i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] && max < dp[j]){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
