package leetcode.easy;

public class ExcelColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * Math.pow(26,s.length()-1 - i);
        }
        return res;
    }
}
