package PAT.advance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String suffix = scanner.nextLine();
        for (int i = 1;i < n;i++){
            String next = scanner.nextLine();
            for (int j = suffix.length()-1, k = next.length()-1; j>=0 && k>=0;j--,k--){
                if(suffix.charAt(j)!= next.charAt(k)){
                    suffix = suffix.substring(j+1);
                    break;
                }
            }
        }
        if(suffix.length()==0){
            System.out.print("nai");
        }else{
            System.out.print(suffix.trim());
        }
    }
}
