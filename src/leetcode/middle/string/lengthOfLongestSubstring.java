package leetcode.middle.string;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int longest = 1;
        String res = s.substring(0,1);
        for (int i = 1; i < s.length(); i++) {
            int j = res.indexOf(s.charAt(i));
            if(j !=-1 ){
                res = res.substring(j+1)+s.charAt(i);
            } else {
                res += s.charAt(i);
            }
            longest = Math.max(longest,res.length());
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new lengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
