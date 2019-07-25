package leetcode.middle.trans;

public class StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        String res = "";
        if (str.charAt(0) == '+' ||str.charAt(0) == '-'){
            res += str.charAt(0);
        }
        str = str.substring(1);
        for (int i = 0; i <str.length(); i++){
            if (str.charAt(i)>='0'&& str.charAt(i)<='9'){
                res+=str.charAt(i);
            }else{
                break;
            }
        }
        try {
            return Integer.parseInt(res);
        } catch (Exception e ){
            if (res==""){
                return 0;
            }
            if (res.charAt(res.length()-1)<='9'&&res.charAt(res.length()-1)>='0'){
                if (res.charAt(0)=='-'){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
    }

}
