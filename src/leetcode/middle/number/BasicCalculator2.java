package leetcode.middle.number;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 0 ;i < s.length();i++){
            switch (s.charAt(i)) {
                case ' ':
                    break;
                case '+':
                    stack.push('+');
                    break;
                case '-':
                    stack.push('-');
                    break;
                case '/':
                    stack.push('/');
                    break;
                case '*':
                    stack.push('*');
                    break;
                default:
                    int cur = s.charAt(i) - '0';
                    while (i + 1 < s.length() && s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0') {
                        i++;
                        cur = cur * 10 + s.charAt(i) - '0';
                    }
                    if (stack.size() == 0){
                        nums.push(cur);
                    }else if (stack.peek() == '/') {
                        int num1 = nums.pop();
                        stack.pop();
                        nums.push(num1/cur);
                    }else if (stack.peek() == '*'){
                        int num1 = nums.pop();
                        stack.pop();
                        nums.push(num1*cur);
                    }else{
                        nums.push(cur);
                    }
            }
        }
        int res = nums.pollLast();
        while(stack.size()!=0){
            char c = stack.pollLast();
            if (c == '-'){
                res -= nums.pollLast();
            }else if (c == '+'){
                res += nums.pollLast();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new BasicCalculator2().calculate("0-2147483647");
    }
}
