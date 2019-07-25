package leetcode.middle.dp;

public class longestPalindrome {
    //其实在第一次遍历true的时候就可以进行分析，以为前i行的数据已经可以直接得到，不需要遍历两次
    public String longestPalindrome(String s) {
        boolean[][] metrix = new boolean[s.length()][s.length()];
        String res ="";
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    metrix[i][j] = true;
                }
            }
        }
        for (int i = 0; i < s.length(); i++){
            String temp = getMaxString(metrix,i,s);
            if (res.length()< temp.length()){
                res = temp;
            }
        }
        return res;
    }

    private String getMaxString(boolean[][] metrix, int i,String s) {
        String res ="";
        int n = i;
        for (int j = i; ; j++, i--){
            if (j >= metrix.length || i < 0){
                res = s.substring(i+1,j);
                break;
            }
            if (metrix[i][j]){
                continue;
            } else {
                res = s.substring(i+1,j);
                break;
            }
        }
        i=n;
        for (int j = i+1;; j++, i--){
            if (j >= metrix.length || i < 0){
                if (j-(i+1) > res.length()) {
                    res = s.substring(i + 1, j);
                }
                break;
            }
            if (metrix[i][j]){
                continue;
            } else {
                if (j-(i+1) > res.length()) {
                    res = s.substring(i + 1, j);
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new longestPalindrome().longestPalindrome("a"));
    }
}
