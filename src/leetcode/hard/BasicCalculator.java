package leetcode.hard;

import java.util.List;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        int cur = 0;
        Stack<Character> stack = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        for (int i = 0 ;i < s.length();i++){
            switch (s.charAt(i)) {
                case ' ':
                    break;
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    while (stack.peek() != '(') {
                        int num2 = nums.pop();
                        int num1 = nums.pop();
                        char c = stack.pop();
                        if (c == '-') {
                            nums.push(num1 - num2);
                        } else {
                            nums.push(num1 + num2);
                        }
                    }
                    stack.pop();
                    cur = nums.pop();
                    doCal(stack,nums,cur);
                    break;
                case '+':
                    stack.push('+');
                    break;
                case '-':
                    stack.push('-');
                    break;
                default:
                    cur = s.charAt(i) - '0';
                    while (i + 1 < s.length() && s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0') {
                        i++;
                        cur = cur * 10 + s.charAt(i) - '0';
                    }
                    doCal(stack,nums,cur);
            }
        }
        return nums.pop();
    }
    public void doCal(Stack<Character> stack, Stack<Integer> nums,int cur){
        if (stack.empty()){
            nums.push(cur);
        }else if (stack.peek() == '-') {
            int num1 = nums.pop();
            stack.pop();
            nums.push(num1 - cur);
        } else if (stack.peek() == '+') {
            int num1 = nums.pop();
            stack.pop();
            nums.push(num1 + cur);
        } else {
            nums.push(cur);
        }
    }
    public static void main(String[] args) {
        new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
