package leetcode.middle.number;

public class rangeBitwiseAnd {
    //201
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n){
            return m;
        }
        if(m == 0){
            return m;
        }
        int res = 0;
        int pow = 1;
        while(n!=0){
            if ((n & 1) == (m & 1)){
                if ((n&1)==1) {
                    res += pow;
                }
            }else{
                res= 0;
            }
            m>>=1;
            n>>=1;
            pow*=2;
        }
        return res;
//        int pow = 1;
//        while(pow*2 <= m  && pow * 2 > 0){
//            pow*=2;
//        }
//        int res = 0;
//
//        while(pow*2 < 0 || (pow <=m && pow * 2 > n)){
//            res+=pow;
//            m %= pow;
//            n %= pow;
//            while(pow>m){
//                pow/=2;
//            }
//        }
//
//        return res;
    }

    public static void main(String[] args) {
        System.out.println(new rangeBitwiseAnd().rangeBitwiseAnd(10,11));
    }
}
