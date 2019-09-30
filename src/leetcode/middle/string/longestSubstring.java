package leetcode.middle.string;

public class longestSubstring {
    public static void main(String[] args) {
        System.out.println(new longestSubstring().longestSubstring("zzzzzzzzzzaaaaaaaaabbbbbbbbhbhbhbhbhbhbhicbcbcibcbccccccccccbbbbbbbbaaaaaaaaafffaahhhhhiaahiiiiiiiiifeeeeeeeeee"
                ,10));
    }
    public int longestSubstring(String s, int k) {
        if(k == 1){
            return s.length();
        }
        return handle(s.toCharArray(), k, 0, s.length());
    }
    public int handle(char[] s, int k, int begin, int end){
        if(end - begin < k){
            return 0;
        }
        int[] arrays = new int[26];
        for(int i = begin; i < end;i++){
            arrays[s[i]-'a']++;
        }
        int max = 0;
        for(int i = begin; i < end; i++){
            if(arrays[s[i]-'a'] >= k){
                if(i == end-1){
                    max = Math.max(max,end-begin);
                }
            } else {
                max = Math.max(max, handle(s,k,begin,i));
                for(int j =begin;j <= i;j++){
                    arrays[s[j]-'a']--;
                }
                begin = i + 1;
            }
        }
        return max;
    }
}
