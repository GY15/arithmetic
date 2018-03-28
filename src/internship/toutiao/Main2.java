package internship.toutiao;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int m = 1, s = 2;

        nextLayer(m,s,n,1);
        System.out.println(minPath);
    }
    static int minPath = 0;
    public static void nextLayer(int m ,int s, int n,int layer){
        if(s==n){
            if(minPath==0){
                minPath=layer;
            }else{
                minPath=Math.min(minPath,layer);
            }
        }else if(s<n){
            layer++;
            nextLayer(s,s*2,n,layer);
            nextLayer(m,s+m,n,layer);
        }else{
            return;
        }
    }
}
