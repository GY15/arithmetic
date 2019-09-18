package leetcode.middle.number;

public class bulbSwitch {
    public static void main(String[] args) {
        int n =new bulbSwitch().bulbSwitch(4);
       n++;
    }
    public int bulbSwitch(int n) {
        if (n == 0){
            return 0;
        }else{
            return (int) Math.pow(n,0.5);
        }
    }
}
