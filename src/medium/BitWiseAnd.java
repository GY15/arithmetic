package medium;

import java.util.Map;
import java.util.Scanner;
public class BitWiseAnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0;i<n;i++){
            int max = 0;
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            for (int j = 1; j<N;j++){
                for (int l=j+1;l<=N;l++){
                    if (K>(l&j)){
                        max = Math.max(max,l&j);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
