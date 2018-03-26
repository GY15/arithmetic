package medium;

public class GetFnEqualOne {
    public static void main(String[] args) {
        int n = 2;
        int res = 1;
        while (f(n)+res!=n){
            res=f(n)+res;
            n++;
        }
        System.out.println(n);
    }
    static int f(int n){
        int num =0;
        String s = n+"";
        for (int i = 0; i < s.length();i++){
            if(s.charAt(i)=='1'){
                num++;
            }
        }
        return num;
    }
}
