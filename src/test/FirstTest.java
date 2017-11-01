package test;

/**
 * Created by 61990 on 2017/9/29.
 */
public class FirstTest {
    public static void main(String[] args) {
        oddNumbers(3,6);
    }
    static int[] oddNumbers(int l, int r) {
        int num=0;
        if(((l+r)%4)==0){
            num=1;
        }
        int n=0;
        if((r-l)%2==0){
            n=(r-l)/2+num;
        }else{
            n=(r-l)/2+1;
        }
        int num2[]= new int[n];
        int j=0;
        for (int i = l; i<=r ; i++){

            if(i%2!=0){
                num2[j]=i;
                j++;
                System.out.println(i);
            }
        }
        return num2;
    }

}
