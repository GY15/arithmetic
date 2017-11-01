package test;

/**
 * Created by 61990 on 2017/10/16.
 */
public class ThrowException {
    public static int pow(int n, int p) throws Exception{
        if(n<0||p<0){
            throw new Exception("n and p should be non-negative");
        }else{
            return (int)Math.pow(n*1.0,p*1.0);
        }
    }
}
