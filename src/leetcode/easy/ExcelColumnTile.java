package leetcode.easy;

public class ExcelColumnTile {
    public String convertToTitle(int n) {
        String[] letters = new String[]{" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        int init = 26;
        String res = "";
        while (true) {
            int curRes = n % 26;
            if (curRes == 0) {
                res = "Z"+ res ;
                n -=  init;
            } else {
                res = letters[curRes]+res;
                n -= curRes;
            }
            n /= init;
            if (n == 0) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new ExcelColumnTile().convertToTitle(701);
    }
}
