package leetcode.middle.trans;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(58));
    }
    public String intToRoman(int num) {
        int n = num / 1000;
        String s = getRoman(n,3);
        num -= n*1000;
        n = num/100;
        s+=getRoman(n,2);
        num -= n*100;
        n = num/10;
        s+=getRoman(n,1);
        num -= n*10;
        n = num/1;
        s+=getRoman(n,0);
        return s;
    }

    private String getRoman(int num, int i) {
        String[] list = new String[]{"I","X","C","M"};
        String[] list2 = new String[]{"V","L","D"};
        String s = "";
        if (num == 0){
            return "";
        }
        if (num <= 3){
            for (int j = 0; j < num;j++){
                s+=list[i];
            }
        }else if(num < 5){
            for (int j = 5; j > num;j--) {
                s += list[i];
            }
            s += list2[i];
        } else if (num <=8 ){
            s += list2[i];
            for (int j = 5; j < num;j++){
                s+=list[i];
            }
        } else {
            for (int j = 10; j > num;j--) {
                s += list[i];
            }
            s += list2[i];
        }
        return s;
    }
}
