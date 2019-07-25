package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BuddyString {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
        if(A.equals(B)){
            for (int i = 0;i<A.length();i++){
                if (A.indexOf(A.charAt(i))!=i){
                    return true;
                }
            }
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length();i++){
            if (A.charAt(i)!=B.charAt(i)){
                if (list.size()==2){
                    return false;
                }
            }
        }
        if (list.size()!=2){
            return false;
        }
        if (A.charAt(list.get(0))==B.charAt(list.get(1)) && A.charAt(list.get(1))==B.charAt(list.get(0))){
            return true;
        }
        return false;
    }
}
