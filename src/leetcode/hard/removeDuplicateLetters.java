package leetcode.hard;

import java.util.Comparator;
import java.util.Map;
import java.util.*;

public class removeDuplicateLetters {
    public static void main(String[] args) {
        new removeDuplicateLetters().removeDuplicateLetters("bcacbdbc");
    }
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (stack.contains(ch)){
                continue;
            }
            while (stack.size() > 0 && stack.peek() > ch && s.lastIndexOf(stack.peek()) > i)
            {
                stack.pop();
            }
            stack.push(ch);
        }
        StringBuilder sb= new StringBuilder();
        while (!stack.empty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}
