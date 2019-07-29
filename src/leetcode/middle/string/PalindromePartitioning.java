package leetcode.middle.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {
    //132题，还有点问题，minCut不太严谨，最好用dp

    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if (s.equals("")){
            return lists;
        }
        addNext(lists,list,s,0);
        return lists;
    }
    void addNext(List<List<String>> lists, List<String> list, String s, int n){
        if (n == s.length()){
            lists.add(list);
            return;
        }
        for (int i = n; i < s.length();i++){
            if(isPalindrome(s,n,i)){
                List<String> list1 = new ArrayList<>(list);
                list1.add(s.substring(n,i+1));
                addNext(lists,list1,s,i+1);
            }
        }
    }
    boolean isPalindrome(String s, int begin, int end){
        for (int i = begin,j = end; i <= j; i++,j--){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
    }
    int n = 0;
    public int minCut(String s){
        nextCut(s,0,s.length()-1,s.length()-1);
        return n-1;
    }
    void nextCut(String s,int begin,int end,int lastCha) {
        if (begin > end) return;
        if (begin == end){
            n++;
            return;
        }
        for (int cha = Math.min(lastCha,end-begin); cha>=0;cha--){
            if (cha == 0){
                n += end-begin+1;
                return;
            }
            for (int i = begin; i + cha <= end; i++){
                if (isPalindrome(s,i,i+cha)){
                    n++;
                    nextCut(s,begin,i-1,cha);
                    nextCut(s,i+cha+1,end,cha);
                    return;
                }
            }
        }
    }

}
