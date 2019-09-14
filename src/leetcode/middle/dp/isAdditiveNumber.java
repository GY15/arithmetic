package leetcode.middle.dp;

public class isAdditiveNumber {
    public static void main(String[] args) {
        new isAdditiveNumber().isAdditiveNumber("123");
    }
    public boolean isAdditiveNumber(String num) {

        return isAdditiveNumber(num,-1,-1);
    }
    private boolean isAdditiveNumber(String num, long num1, long num2){

        if (num1 < 0){
            for(int i = 0; i < num.length()/2 && i < 15;i++){
                if (num.charAt(0) == '0' && i > 0){
                    continue;
                }
                num1 = Long.parseLong(num.substring(0,i+1));
                System.out.println(num.length()+i+2);
                for (int j = i + 1 + 1; j < num.length() && j-(i+1) < 15 && j < (num.length()+i+2)/2+3; j++){
                    if (num.charAt(i+1) == '0' && j >i+2){
                        break;
                    }
                    num2 =  Long.parseLong(num.substring(i+1,j));
                    if(isAdditiveNumber(num.substring(j), num1, num2)){
                        return true;
                    }
                }
            }
        }else{
            String next = (num1+num2) +"";
            if (next.length() > num.length()){
                return  false;
            }else if (next.equals(num)){
                return true;
            }else {
                for (int i = 0; i < next.length(); i++) {
                    if (next.charAt(i) != num.charAt(i)) {
                        return false;
                    }
                }
                return isAdditiveNumber(num.substring(next.length()), num2, Long.parseLong(next));
            }
        }
        return false;
    }
}
