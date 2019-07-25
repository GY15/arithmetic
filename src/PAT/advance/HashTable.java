package PAT.advance;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxSize = scanner.nextInt();
        int inputNum = scanner.nextInt();
        maxSize = re(maxSize);
        Set<Integer> set =new HashSet<>();

        int nextInt = scanner.nextInt()%maxSize;
        set.add(nextInt);
        System.out.print(nextInt);
        for (int i = 1; i < inputNum; i++){
            nextInt = scanner.nextInt()%maxSize;
            if(set.contains(nextInt)){
                System.out.print(" -");
            }else{
                set.add(nextInt);
                System.out.print(" "+nextInt);
            }
        }
    }


    private static int re(int size){
        if(size<=2)
            return 2;
        while(!isPrime(size))
            size++;
        return size;
    }
    private static boolean isPrime(int num){
        int limit = (int)Math.sqrt(num);
        for(int i = 2;i<=limit;i++)
            if(num%i==0)
                return false;
        return true;
    }
}
