package leetcode.middle.number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class EvaluateReverse {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i =0;i<tokens.length;i++){
            switch (tokens[i]){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    int i1 = stack.pop();
                    int i2 = stack.pop();
                    stack.push(i2-i1);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    int i3 = stack.pop();
                    int i4 = stack.pop();
                    stack.push(i4/i3);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }

    public String reverseWords(String s) {
        s = s.trim().replaceAll(" +"," ");


        String[] strings = s.split(" ");
        List<String> ss = Arrays.asList(strings);
        Collections.reverse(ss);
        StringBuilder sss = new StringBuilder();
        for (int i = 0;i < ss.size()-1;i++){
            sss.append(ss.get(i));
            sss.append(" ");
        }
        sss.append(ss.get(ss.size()-1));
        return sss.toString();
    }

    public static void main(String[] args) {
        new EvaluateReverse().reverseWords("a good   example");
    }
}
