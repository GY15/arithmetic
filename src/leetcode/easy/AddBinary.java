package leetcode.easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuffer s = new StringBuffer();
        int bit = 0;
        int i = b.length()-1;
        int j = a.length()-1;
        while(i>=0&&j>=0){
            int sum = b.charAt(i)-'0' + a.charAt(j)-'0' + bit;
            if(sum >= 2){
                sum-=2;
                bit=1;
            }else{
                bit = 0;
            }
            s.append(sum);
            i--;
            j--;
        }
        while(i>=0){
            int sum = b.charAt(i)-'0'+bit;
            if(sum >= 2){
                sum-=2;
                bit=1;
            }else{
                bit = 0;
            }
            i--;
            s.append(sum);
        }
        while(j>=0){
            int sum = a.charAt(j)-'0'+bit;
            if(sum >= 2){
                sum-=2;
                bit=1;
            }else{
                bit = 0;
            }
            j--;
            s.append(sum);
        }
        if (bit==1){
            s.append(1);
        }
        return s.reverse().toString();
    }
    public int mySqrt(int x) {
        int i=1;
        while (true){
            if (i*i<x){
                i*=2;
            }else if(i*i==x){
                return i;
            }else{
                break;
            }
        }
        while (true){
            if (i*i<=x){
                return i;
            }else{
                i--;
            }
        }
    }
}
