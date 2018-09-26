package PAT;

import java.util.Scanner;

public class IDcard {
    public static void main(String[] args) {
        int numOfInvalid = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int weight[] =new int[]{7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        for (int i = 0; i < n; i++){
            String line = scanner.nextLine();
            boolean valid = true;
            int total = 0;
            for (int j =0;j<line.length()-1;j++){
                int num = line.charAt(j)-'0';
                if(num<=9&&num>=0){
                    total += num*weight[j];
                }else{
                    numOfInvalid++;
                    valid=false;
                    break;
                }
            }
            if(valid){
                char last=line.charAt(17);
                if(last=='X'){
                    last=10;
                }else{
                    last-='0';
                }
                if((total%11+last == 1)||(total%11+last)==12){

                }else{
                    numOfInvalid++;
                    System.out.println(line);
                }
            }else{
                System.out.println(line);
            }
        }
        if(numOfInvalid==0){
            System.out.println("All passed");
        }
    }
}
