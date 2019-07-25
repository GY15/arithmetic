package leetcode.hard;

//need do again
public class WildcardMatching {
    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("abcabcabab","a*a*abab"));
    }
    //匹配正则*和？  好想法，从最后一个向前匹配，看是否能让第一个字符匹配到，重新写！
    public boolean isMatch(String s, String p) {
        boolean[][] match=new boolean[s.length()+1][p.length()+1];
        match[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                match[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                    match[i][j]=match[i+1][j+1];
                else if(p.charAt(j)=='*')
                    match[i][j]=match[i+1][j]||match[i][j+1];
                else
                    match[i][j]=false;
            }
        }
        return match[0][0];
    }


    public boolean isMatch2(String s, String p) {

        if(s.equals(p)||p.equals("*")){
            return true;
        }else if(p.equals("")){
            return false;
        }else{
            StringBuffer ss = new StringBuffer();
            ss.append(p.charAt(0));
            for (int i = 1 ;i < p.length();i++){
                if (p.charAt(i)=='*' && p.charAt(i-1)=='*'){

                }else{
                    ss.append(p.charAt(i));
                }
            }
            p=ss.toString();
            return match(s,p,0,0);
        }
    }
    boolean match(String s, String p, int s_index, int p_index){
        if (p_index==p.length()-1 && p.charAt(p_index)=='*' && s.length()==s.length()){
            return true;
        }
        if (p_index == p.length()||s_index==s.length()){
            return false;
        }
        if (p.charAt(p_index) == '?'){
            if (s.length() - 1 == s_index && p.length()-1==p_index){
                return true;
            }else{
                return match(s,p,s_index+1,p_index+1);
            }
        } else if (p.charAt(p_index) == '*'){
            if (s.length()-1==s_index && p.length()-1 == p_index){
                return true;
            }
            for (int i = s_index+1; i < s.length();i++){
                if(match(s,p,i,p_index)){
                    return true;
                }
            }
            return match(s,p,s_index,p_index+1);
        } else {
            if (s.charAt(s_index)==p.charAt(p_index)){
                if (s_index == s.length()-1 && p_index == p.length()-1) {
                    return true;
                }else {
                    return match(s, p, s_index + 1, p_index + 1);
                }
            }else{
                return false;
            }
        }
    }
}
