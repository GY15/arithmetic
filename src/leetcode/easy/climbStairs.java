package leetcode.easy;

public class climbStairs {
    public static void main(String[] args) {
        new climbStairs().climbStairs(3);
    }
    public int climbStairs(int n) {
        int[] res = new int[n+2];
        res[0] = 1;
        for (int i = 0; i < n; i++){
            res[i+1] +=res[i];
            res[i+2]+=res[i];
        }
        return res[n];
    }
}
