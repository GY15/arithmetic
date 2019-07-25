package leetcode.hard;

public class LongestValidParentheses {
    // 匹配括号的最长字符串长度
    // 动态规划，按照当前符号和之前的状态得出现在i的最大长度
/*
    If s[i] is '(', set longest[i] to 0,because any string end with '(' cannot be a valid one.

            Else if s[i] is ')'

    If s[i-1] is '(', longest[i] = longest[i-2] + 2

    Else if s[i-1] is ')' and s[i-longest[i-1]-1] == '(', longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]

    For example, input "()(())", at i = 5, longest array is [0,2,0,0,2,0], longest[5] = longest[4] + 2 + longest[1] = 6.
    */
    public int longestValidParentheses(String s) {
        if(s.length() <= 1) return 0;
        int curMax = 0;
        int[] longest = new int[s.length()];
        for(int i=1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    longest[i] = (i-2) >= 0 ? (longest[i-2] + 2) : 2;
                    curMax = Math.max(longest[i],curMax);
                }
                else{ // if s[i-1] == ')', combine the previous length.
                    if(i-longest[i-1]-1 >= 0 && s.charAt(i-longest[i-1]-1) == '('){
                        longest[i] = longest[i-1] + 2 + ((i-longest[i-1]-2 >= 0)?longest[i-longest[i-1]-2]:0);
                        curMax = Math.max(longest[i],curMax);
                    }
                }
            }
            //else if s[i] == '(', skip it, because longest[i] must be 0
        }
        return curMax;
    }
    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
    }
}
