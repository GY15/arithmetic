package leetcode.hard;

import java.util.Arrays;

// only two transaction
public class BestTimetoBuyandSellStock5 {
    //188

    public int maxProfit(int k, int[] prices) {
        int[] sells = new int[k];
        int[] buys = new int[k];
        Arrays.fill(buys,Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < buys.length;j++){
                if (j!=0) {
                    buys[j] = Math.max(buys[j], sells[j-1] - prices[i]);
                }else{
                    buys[j] = Math.max(buys[0], -prices[i]);
                }
                sells[j] = Math.max(sells[j],buys[j] + prices[i]);
            }
        }
        return sells[sells.length-1];
    }
}
