package leetcode.easy;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(2));
    }
    public String countAndSay(int n) {
        return say("1",n);
    }
    String say(String s, int n){
        int count = 0;
        char cur = ' ';
        String res = "";
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (cur==' '){
                count=1;
                cur = c;
            }else {
                if (c == cur) {
                    count++;
                } else {
                    res+=count+""+cur;
                    count = 1;
                    cur = c;
                }
            }
            if (i == s.length()-1 &&cur!=' '){
                res+=count+""+cur;
            }
        }
        if (n <= 2){
            return res;
        }else{
            return say(res,n-1);
        }
    }
}
