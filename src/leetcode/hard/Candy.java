package leetcode.hard;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0){
            return 0;
        } else if (ratings.length == 1){
            return 1;
        }
        int last = ratings[0];
        int lll = 1;
        int index = 0;
        int lastCandy = 1;
        int candy = 1;
        for (int i = 1; i < ratings.length;i++){
            if (ratings[i]==ratings[i-1]){
                lastCandy = 1;
                candy++;
                last = ratings[i];
                lll = 1;
                index = i;
                continue;
            }
            if (ratings[i] > last || ratings[i] > ratings[i-1]){
                last = ratings[i];
                lastCandy ++;
                lll = lastCandy;
                candy += lastCandy;
                index = i;
            } else {
                if (i-index < lll){
                    candy += i - index;
                } else {
                    candy += i-index+1;
                }
                lastCandy = 1;
            }
        }
        return candy;
    }

    public static void main(String[] args) {
        new Candy().candy(new int[]{1,2,3,5,4,3,2,1,4,3,2,1});
    }
}
