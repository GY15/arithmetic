package leetcode.middle.string;

import java.util.Stack;

public class decodeString {
    public static void main(String[] args) {
        new decodeString().decodeString("3[a2[c]]");
    }

    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<String> strs = new Stack<>();
        String temp = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) <= '9'){
                int cur = s.charAt(i) - '0';
                while(i + 1 < s.length() && s.charAt(i+1) <= '9'){
                    cur = cur * 10 + s.charAt(++i)- '0';
                }
//                if(strs.empty()){
//                    sb.append(temp);
//                }else {
//                    strs.push(strs.pop() + temp);
//                }
//                temp = "";
                stack.push(cur);
            }else if(s.charAt(i) == '['){
                while(i+1 < s.length() && s.charAt(i+1) >= 'a' && s.charAt(i+1)<='z'){
                    temp += s.charAt(++i);
                }
//                if(s.charAt(i + 1) == ']'){
                    strs.push(temp);
                    temp = "";
//                }
            }else if(s.charAt(i) == ']'){
                int count = stack.pop();
                String tt = strs.pop();
                String ttt = "";
                for(int n = 0; n < count; n++){
                    ttt += tt;
                }
                if(!strs.empty()){
                    strs.push(strs.pop()+ttt);
                }else{
                    sb.append(ttt);
                }
            }else{
                temp += s.charAt(i);
                while(i+1 < s.length() && s.charAt(i+1) >= 'a' && s.charAt(i+1)<='z'){
                    temp += s.charAt(++i);
                }
                if(!strs.empty()){
                    strs.push(strs.pop()+temp);
                }else{
                    sb.append(temp);
                }
                temp = "";
            }
        }
            return sb.toString();
    }
}
