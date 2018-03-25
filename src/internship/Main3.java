package internship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0;i<n;i++){
            String line = scanner.nextLine();

            String operator = getNextInt(line);
            line = line.substring(operator.length(),line.length());
            List<Integer> list= new ArrayList<>();
            list.add(Integer.parseInt(operator));
            List<Character> operations = new ArrayList<>();
            while (true){
                char operation = line.charAt(0);
                operations.add(operation);
                line = line.substring(1,line.length());

                operator = getNextInt(line);
                line = line.substring(operator.length(),line.length());
                list.add(Integer.parseInt(operator));
                if(line.length()==0){
                    break;
                }
            }
            for (int j = 0; j < operations.size();j++){
                if(operations.get(j)=='*'){
                    int temp =list.get(j)*list.get(j+1);
                    list.remove(j);
                    list.remove(j);
                    operations.remove(j);
                    list.add(j,temp);
                    j--;
                }
            }
            int result = list.get(0);
            for (int j = 0; j < operations.size();j++){
                if(operations.get(j)=='+'){
                    result+=list.get(j+1);
                }else{
                    result-=list.get(j+1);
                }
            }
            print(result);
        }
        return;
    }
    private static String getNextInt(String s){

        for (int i = 0 ; i < s.length();i++){
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'){
                return s.substring(0,i);
            }
        }
        return s;
    }
    private static void print(int num){
        String lines[] = new String[]{"","","","",""};
        for (int i = 0; i < (num+"").length();i++){
            if(i!=0){
                lines[0]+="..";
                lines[1]+="..";
                lines[2]+="..";
                lines[3]+="..";
                lines[4]+="..";
            }
            switch ((num+"").charAt(i)) {
                case '0':
                    lines[0]+="66666";
                    lines[1]+="6...6";
                    lines[2]+="6...6";
                    lines[3]+="6...6";
                    lines[4]+="66666";
                    break;
                case '1':
                    lines[0]+="....6";
                    lines[1]+="....6";
                    lines[2]+="....6";
                    lines[3]+="....6";
                    lines[4]+="....6";
                    break;
                case '2':
                    lines[0]+="6666a6";
                    lines[1]+="....6";
                    lines[2]+="66666";
                    lines[3]+="6....";
                    lines[4]+="66666";
                    break;
                case '3':
                    lines[0]+="66666";
                    lines[1]+="....6";
                    lines[2]+="66666";
                    lines[3]+="....6";
                    lines[4]+="66666";
                    break;
                case '4':
                    lines[0]+="6...6";
                    lines[1]+="6...6";
                    lines[2]+="66666";
                    lines[3]+="....6";
                    lines[4]+="....6";
                    break;
                case '5':
                    lines[0]+="66666";
                    lines[1]+="6....";
                    lines[2]+="66666";
                    lines[3]+="....6";
                    lines[4]+="66666";
                    break;
                case '6':
                    lines[0]+="66666";
                    lines[1]+="6....";
                    lines[2]+="66666";
                    lines[3]+="6...6";
                    lines[4]+="66666";
                    break;
                case '7':
                    lines[0]+="66666";
                    lines[1]+="....6";
                    lines[2]+="....6";
                    lines[3]+="....6";
                    lines[4]+="....6";
                    break;
                case '8':

                    lines[0]+="66666";
                    lines[1]+="6...6";
                    lines[2]+="66666";
                    lines[3]+="6...6";
                    lines[4]+="66666";
                    break;
                case '9':

                    lines[0]+="66666";
                    lines[1]+="6...6";
                    lines[2]+="66666";
                    lines[3]+="....6";
                    lines[4]+="66666";
                    break;
            }
        }
        for (int s =0;s<5;s++){
            System.out.println(lines[s]);
        }
    }

}
