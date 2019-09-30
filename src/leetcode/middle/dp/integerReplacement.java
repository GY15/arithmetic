package leetcode.middle.dp;

public class integerReplacement {
    public static void main(String[] args) {
        new integerReplacement().integerReplacement(100000000);
    }
    public int integerReplacement(int n) {
        int[] bits = new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728};
        int count = 0;
        if (n == 1){
            return 0;
        }
        if( n == 3){
            return 2;
        }
        for(int i = bits.length - 1; i >= 0; i--){
            if(bits[i] == n){
                return count+i;
            }

            if(n < bits[i] && n <=bits[i-1]){
                continue;
            }
            if(n % 2 == 0){
                n/=2;
                count++;
            }else{
                n = (n - 1) /2;
                count+=2;
            }
        }
        return count;
    }
}
