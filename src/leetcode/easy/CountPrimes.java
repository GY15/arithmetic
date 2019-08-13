package leetcode.easy;

public class CountPrimes {
    //204
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++){
            if (primes[i]==false){
                count++;
                for (int j = 2;j*i<n;j++){
                    primes[i]=true;
                }
            }
        }
        return count;
    }
}
