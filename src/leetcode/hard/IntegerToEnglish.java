package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class IntegerToEnglish {
    public static void main(String[] args) {
        System.out.println(new IntegerToEnglish().numberToWords(100000));
    }
    List<String> list = new ArrayList<>();
    public String numberToWords(int num) {

        String[] digitGroup = initDigitGroup(num+"");
        return handleDigitGroup(digitGroup);

    }

    /**
     * 处理各段切分好的dig并返回结果
     */
    private String handleDigitGroup(String[] digGroup) {
        String[] digitUnit = new String[]{"Billion", "Million", "Thousand", ""};
        for (int i = 0; i < digGroup.length; i++) {
            if (digGroup[i] != null) {
                list.addAll(handleThreeBitDigit(digGroup[i], digitUnit[i]));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<list.size();i++){
            if (i==0){
                stringBuilder.append(list.get(i));
            }else{
                stringBuilder.append(" " + list.get(i));
            }
        }
        return stringBuilder.toString().trim();
    }

    private List<String> handleThreeBitDigit(String num, String unit) {
        if (Integer.parseInt(num) == 0) {
            return new ArrayList<>();
        }
        String[] numToWords = new String[]{ // 基本数词表
                "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                "Twenty", "", "", "", "", "", "", "", "", "", "Thirty", "", "", "",
                "", "", "", "", "", "", "Forty", "", "", "", "", "", "", "", "",
                "", "Fifty", "", "", "", "", "", "", "", "", "", "Sixty", "", "",
                "", "", "", "", "", "", "", "Seventy", "", "", "", "", "", "", "",
                "", "", "Eighty", "", "", "", "", "", "", "", "", "", "Ninety"};
        char[] chars = num.toCharArray();
        List<String> s = new ArrayList<>();
        if (chars[0] != '0') {
            s.add(numToWords[chars[0] - '0']);
            s.add("Hundred");
        }
        int lastTwo = Integer.parseInt(num) % 100;
        if (lastTwo <= 20 && lastTwo!=0) {
            s.add(numToWords[lastTwo]);
        } else {
            if (chars[1] != '0') {
                s.add(numToWords[(chars[1] - '0') * 10]);
            }
            if (chars[2] != '0') {
                s.add(numToWords[chars[2] - '0']);
            }
        }
        if(!unit.equals(""))
            s.add(unit);
        return s;
    }

    /**
     * 将String每三个字符切为4段并返回
     */
    private String[] initDigitGroup(String number) {
        String[] digGroup = new String[4];
        int length = number.length();
        for (int i = 3; i >= 0; i--, length -= 3) {
            if (length - 3 > 0) {
                digGroup[i] = number.substring(length - 3, length);
            } else {
                digGroup[i] = number.substring(0, length);
                if (digGroup[i].length() == 1) {
                    digGroup[i] = "00" + digGroup[i];
                } else if (digGroup[i].length() == 2) {
                    digGroup[i] = "0" + digGroup[i];
                }
                break;
            }
        }
        return digGroup;
    }

}
