package PAT.advance;

import java.util.Scanner;

public class ConsecutiveFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();
        int max = 0;
        int begin = 2;
        int point = 2;
        int total = 2;
        for (int i = 3; i < Math.pow(temp,0.5); i++){
            total *= i;
            if(temp%total == 0){
                if(max < (i-point+1)){
                    begin = point;
                    max = i-point+1;
                }
            }else{
                while (true) {
                    total /= point;
                    point++;
                    if(temp%total==0){
                        if(max < (i-point+1)){
                            begin = point;
                            max = i-point+1;
                        }
                        break;
                    }
                }
            }
        }
        if(max==0){
            System.out.println(1);
            System.out.println(temp);
        }else {
            System.out.println(max);
            if (max == 1) {
                if(temp%2 ==0) {
                    System.out.println(2);
                }else{
                    System.out.println(begin);
                }
            } else {
                for (int i = begin; i < max + begin; i++) {
                    System.out.print(i);
                    if (i != max + begin - 1) {
                        System.out.print("*");
                    }
                }
            }
        }
    }
}
