package leetcode.middle.tree;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        isInterleave(s1,0,s2,0,s3);
        return false;
    }
    public boolean isInterleave(String s1, int i1, String s2, int i2, String s3) {
        if (i1 == s1.length() && i2 == s2.length()) {
            return true;
        } else {
            if (i1 < s1.length() && s1.charAt(i1)==s3.charAt(i1+i2)){
                if (isInterleave(s1,i1+1,s2,i2,s3)){
                    return true;
                }
            }
            if (i2 < s2.length() && s2.charAt(i2)==s3.charAt(i1+i2)){
                if (isInterleave(s1,i1,s2,i2+1,s3)){
                    return true;
                }
            }
            return false;
        }
    }

}