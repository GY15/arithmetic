package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class addOperators {
    public static void main(String[] args) {
        new addOperators().addOperators("123",6);
    }
    public List<String> addOperators(String num, int target) {
         List<Integer> numbers = new ArrayList<>();
         List<List<Character>> operators = new ArrayList<>();
         for (int i = 0; i < num.length(); i++){
             numbers.add(num.charAt(i)- '0');
         }
         List<Character> chars = new ArrayList<>();
         operators.add(chars);
         for (int i = 0; i < numbers.size()-1;i++){
            for (int j = operators.size()-1; j >=0; j--){
                List<Character> temp = operators.get(j);
                List<Character> temp1 = new ArrayList<>(temp);
                temp1.add(' ');
                List<Character> temp2 = new ArrayList<>(temp);
                temp2.add('-');
                List<Character> temp3 = new ArrayList<>(temp);
                temp3.add('*');
                temp.add('+');
                operators.add(temp1);
                operators.add(temp2);
                operators.add(temp3);
            }
         }
         List<String> res = new ArrayList<>();
         for (int i = 0; i < operators.size();i++){
             String s = handle(new ArrayList<>(numbers),operators.get(i),target);
             if (!s.equals("")){
                 res.add(s);
             }
         }
         return res;
    }

    private StringBuilder listToString(List<Integer> numbers, List<Character> operators) {
        StringBuilder  stringBuilder = new StringBuilder();
        stringBuilder.append(numbers.get(0));
        for (int i = 0; i < operators.size();i++){
            stringBuilder.append(operators.get(i));
            stringBuilder.append(numbers.get(i+1));
        }
        return stringBuilder;
    }

    private String handle(List<Integer> numbers, List<Character> operator, int target) {


        for (int i = 0; i < operator.size(); i++){
            if (operator.get(i)==' '){
                if (numbers.get(i)==0){
                    return "";
                }
                int num = numbers.remove(i) *10 +numbers.remove(i);
                numbers.add(i,num);
                operator.remove(i);
                i--;
            }
        }
        StringBuilder strs =  listToString(numbers,operator);
        for (int i = 0; i < operator.size(); i++){
            if (operator.get(i)=='*'){
                int num = numbers.remove(i) * numbers.remove(i);
                numbers.add(i,num);
                operator.remove(i);
                i--;
            }
        }
        int res = numbers.get(0);
        for (int i = 0; i < operator.size(); i++){
            if (operator.get(i)=='+'){
                res += numbers.get(i+1);
            }else if (operator.get(i)=='-'){
                res -= numbers.get(i+1);
            }
        }
        if (res == target){
            return strs.toString();
        }
        return "";
    }
}
