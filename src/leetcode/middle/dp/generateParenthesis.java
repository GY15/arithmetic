package leetcode.middle.dp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class generateParenthesis {

    //生成一系列全遍历的括号，这里比较复杂，其实可以考虑dp。将当前状态和当前字符串传到下一层添加下一个字符
    public static void main(String[] args) {
        new generateParenthesis().generateParenthesis(4);
    }
    public List<String> generateParenthesis(int n) {
        String temp ="";
        for(int i =0; i<n;i++){
            temp+="(";
        }
        LinkedList<String> res =new LinkedList<>();
        res.add(temp);
        for(int i =0; i < n;i++){
            while(res.peek().length()==i+n){
                String str = res.remove();
                int left = 0;
                int right = i;
                for (int j= 0; j < str.length(); j++){
                    if (str.charAt(j) == '('){
                        left++;
                    } else{
                        right--;
                        left--;
                    }
                    if (left > 0 && right == 0) {
                        res.add(str.substring(0, j+1) + ")" + str.substring(j+1));
                        left--;
                    }
                }
            }
        }
       Collections.sort(res);
        return res;
    }
}
