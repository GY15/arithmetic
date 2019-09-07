package leetcode.middle.number;

public class numSquares {
    public int numSquares(int n) {
        if (n < 2){
            return n;
        }
        int res = Integer.MAX_VALUE;
        int i = (int) Math.pow(n,0.5);
        for (int square = i; square >= i-4 && square>=1; square--){
            res = Math.min(res,numSquares(n - square*square)+1);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new numSquares().numSquares(192));
    }
}
