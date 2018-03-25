package easy;

import java.util.Scanner;

public class LaterPeople {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testnum = scanner.nextInt();
        for(int i = 0;i<testnum;i++){
            int people = scanner.nextInt();
            int except = scanner.nextInt();
            for(int j = 0; j < people;j++){
                int time = scanner.nextInt();
                if(time<=0){
                    except--;
                }
            }
            System.out.println(except>0?"NO":"YES");

        }

    }
}
