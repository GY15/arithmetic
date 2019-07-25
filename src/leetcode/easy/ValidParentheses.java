package leetcode.easy;

import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        String left = "({[";
        String right = ")}]";
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0;i<s.length();i++){
            if (left.indexOf(s.charAt(i))>=0){
                list.push(s.charAt(i));
            } else{
                char c =left.charAt(right.indexOf(s.charAt(i)));
                if(c != list.pop()){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new ValidParentheses().isValid("{([])}");
    }
}
