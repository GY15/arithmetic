package leetcode.easy;

public class plusOne {
    public int[] plusOne(int[] digits) {
        int index= -1;
        for (int i =0;i<digits.length;i++){
            if (digits[i]!=9){
                index=i;
            }
        }
        if (index==-1){
            int[] ff= new int[digits.length+1];
            ff[0]=1;
            return ff;
        }
        for (int i = digits.length-1;i>index;i--){
            digits[i]=0;
        }
        digits[index]++;
        return digits;
    }
}
