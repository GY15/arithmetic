package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class uniqueLetterString {
    //打死我也想不到大神的想法
    public int uniqueLetterString(String s) {
        int total = 0;
        Map<Character,Integer> map = new HashMap<>();
        int nums1 [] = new int[s.length()];
        int nums2 [] = new int[s.length()];
        nums1[0] = 1;
        int nums3 [];
        for (int i = 0; i < s.length();i++){
            for (int j = 0; j <= i; j++){
                if (j==0){
                    total+=1;
                    nums2[j] = 1;
                }else {
                    if (s.charAt(i) == s.charAt(i - j)) {
                        nums2[j] = nums2[j - 1] - 1;
                    } else {
                        if (j-2 >= 0 && nums1[j-1] < nums1[j-2]){
                            nums2[j] = nums2[j - 1] - 1;
                        }else {
                            nums2[j] = nums2[j - 1] + 1;
                        }
                    }
                    if (nums2[j] < 0){
                        nums2[j] = 0;
                    }
                    total += nums2[j];
                }
            }
            nums3 = nums2;
            nums2 = nums1;
            nums1 = nums3;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new uniqueLetterString().uniqueLetterString2("LETTER"));
    }
    public int uniqueLetterString2(String S) {

        int res = 0;
        if (S == null || S.length() == 0)
            return res;
        int[] showLastPosition = new int[26];
        int[] contribution = new int[26];
        int cur = 0;
        for (int i = 0; i < S.length(); i++) {
            char x = (char) (S.charAt(i) - 'A');
            cur -= contribution[x];
            contribution[x] = (i - (showLastPosition[x] - 1));
            cur += contribution[x];
            showLastPosition[x] = i + 1;
            res += cur;
        }
        return res;
    }
}
