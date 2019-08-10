package leetcode.easy;

public class Numberof1 {
    //191
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i<32;i++){
            if (n == 0){
                break;
            }
            res += (n&1);
            n >>= 1;

        }
        return res;
    }
}
