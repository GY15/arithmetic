package leetcode.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0,j = s.length()-1;
        char c1,c2;
        while(i < j){
            c1 = s.charAt(i);
            if (c1<= 'z'&& c1>='a' ||c1<='9'&&c1>='0'){

            }else{
                i++;
                continue;
            }
            c2 = s.charAt(j);
            if (c2<= 'z'&& c2>='a' ||c2<='9'&&c2>='0'){

            }else{
                j--;
                continue;
            }
            if (c1!=c2){
                return false;
            }else{
                j--;
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A mam,a"));
    }
}
