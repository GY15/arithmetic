package leetcode.easy;

public class reverse {
    public int reverse(int x) {
        String res = "";
        String sign = "";
        String xToString = x + "";
        for (int i = 0; i < xToString.length(); i++) {
            if (i == 0 && xToString.charAt(i) == '-') {
                sign = "-";
                continue;
            }
            res = xToString.charAt(i) + res;
        }
        try {
            return Integer.parseInt(sign + res);
        } catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new reverse().reverse(1534236469));
    }
}
