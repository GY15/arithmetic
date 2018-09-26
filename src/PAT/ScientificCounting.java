package PAT;

import java.util.Scanner;

public class ScientificCounting {
    public static void main(String[] args) {
        String line = new Scanner(System.in).nextLine();
        new Counting(line).print();
    }
    static class Counting{
        String symbol;
        int bit;
        double number;
        int bit2;
        int bit3;
        String str;
        Counting(String line){
            symbol= line.charAt(0)+"";
            String[] strs = line.substring(1).split("E");
            String s[] = strs[0].split("\\.");
            str = strs[0];
            number = Double.parseDouble(strs[0]);
            bit = -(s[1].length());
            bit2 =  Integer.parseInt(strs[1]);
            bit3 = s[0].length();
        }

        public void print() {
            if(symbol.equals("-")){
                System.out.println("-");
            }
            if(bit+bit2>=0){
                System.out.print( (str+"").replace(".",""));
                for (int i =0; i< bit+bit2;i++){
                    System.out.print("0");
                }
            }else {
                if (bit < 0) {
                    if (bit3 + bit2 <= 0) {
                        System.out.print( "0.");
                        for (int i = 0; i < -(bit3 + bit2); i++) {
                            System.out.print("0");
                        }
                        System.out.println((str + "").replace(".", ""));
                    } else {
                        System.out.println( String.format("%." + (-bit - bit2) + "f", (number * Math.pow(10, bit2))));
                    }
                } else {
                    System.out.println( String.format("%." + (-bit - bit2) + "f", (number * Math.pow(10, bit2))));
                }
            }
        }
    }
}
