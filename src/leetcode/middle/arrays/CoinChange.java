package leetcode.middle.arrays;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        new CoinChange().coinChange(new int[]{1,2,5},11);
    }
    public int coinChange(int[] coins, int amount) {
        if (amount<=0){
            return 0;
        }
        int[] res = new int[amount+1];
        Arrays.sort(coins);
        if (coins.length == 0 || coins[0] > amount ){
            return -1;
        }

        for (int i = 0; i < coins.length && coins[i] <= amount;i++){
            res[coins[i]] = 1;
        }
        for (int i = coins[0] + 1; i <= amount;i++){
            for (int coin : coins){
                if (i - coin > 0 && res[i - coin]>0) {
                    if (res[i] == 0) {
                        res[i] = res[i - coin] + 1;
                    } else {
                        res[i] = Math.min(res[i], res[i - coin] + 1);
                    }
                }
            }
        }
        return res[amount] == 0? -1: res[amount];
    }
}
