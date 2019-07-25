package PAT.advance;

import java.util.Scanner;

public class SupplyChain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int memberNum = scanner.nextInt();
        double P = scanner.nextDouble();
        double rate = scanner.nextDouble();

        int[] num= new int[memberNum];
        for (int i = 0; i < memberNum;i++){
            num[i] = scanner.nextInt();
        }
        int maxDepth  = 0;
        int numOfMax = 0;
        for (int i = 0; i < memberNum; i++){
            int curDepth = 0;
            int last =num[i];
            while (true){
                if(last != -1){
                    last=num[last];
                    curDepth++;
                }else{
                    if(maxDepth == curDepth){
                        numOfMax++;
                    }else if(maxDepth < curDepth){
                        numOfMax = 1;
                        maxDepth = curDepth;
                    }
                    break;
                }
            }
        }
        System.out.println(String.format("%.2f",P*Math.pow(1+rate*0.01,maxDepth)) +" "+ numOfMax);
    }
}
