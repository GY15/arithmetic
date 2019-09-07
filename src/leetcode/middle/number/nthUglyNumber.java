package leetcode.middle.number;

public class nthUglyNumber {
    //164
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0]=1;
        int i2=0,i3=0,i5 = 0;
        int factory2 = 2;
        int factory3 = 3;
        int factory5 = 5;
        for (int i = 1;i < n;i++){
            int cur = Math.min(Math.min(factory2,factory3),factory5);
            res[i] = cur;
            if(cur == factory2){
                factory2 = 2 * res[++i2];
            }
            if(cur == factory3){
                factory3 = 3 * res[++i3];
            }
            if(cur == factory5){
                factory5 = 5 * res[++i5];
            }
        }
        return res[n-1];
    }
}
