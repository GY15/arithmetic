package internship.huawei;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = "";

        String l = scanner.nextLine().trim();
        String group[] = l.split(":");
        String line ="";
        if(group.length!=8){
            type = "Error";
        }else{
            for (int i = 0; i<group.length;i++) {
                if (group[i].length()!=4){
                    type="Error";
                }else {
                    line += group[i];
                }
            }
        }
        if (!type.equals("Error")) {
            if (line.length() != 32) {
                type = "Error";
            } else {

                StringBuffer res = new StringBuffer("");
                int zero = 0;
                int one = 0;
                for (int i = 0; i < 32; i++) {
                    String s = convert(line.charAt(i));
                    if (s.equals("Error")) {
                        type = "Error";
                        break;
                    } else {
                        res.append(s);
                    }
                }
                if (res.toString().replaceAll("1", "").length() == 128) {
                    type = "Unspecified";
                } else if (res.toString().substring(0,8).replaceAll("0", "").length() == 8) {
                    type = "Multicast";
                } else if (res.toString().substring(0, 10).equals("1111111010")) {
                    type = "LinkLocal";
                } else if (res.toString().substring(0, 10).equals("1111111011")) {
                    type = "SiteLocal";
                } else {
                    if (res.toString().charAt(127) == '1' && res.toString().replaceAll("1", "").length() == 127) {
                        type = "Loopback";
                    } else {
                        type = "GlobalUnicast";
                    }
                }


            }
        }
        System.out.println(type);
    }

    static String convert(char s) {
        switch (s) {
            case '0':
                return "0000";
            case '1':
                return "0001";
            case '2':
                return "0010";
            case '3':
                return "0011";
            case '4':
                return "0100";
            case '5':
                return "0101";
            case '6':
                return "0110";
            case '7':
                return "0111";
            case '8':
                return "1000";
            case '9':
                return "1001";
            case 'A':
                return "1010";
            case 'B':
                return "1011";
            case 'C':
                return "1100";
            case 'D':
                return "1101";
            case 'E':
                return "1110";
            case 'F':
                return "1111";
            default:
                return "Error";
        }
    }
}
