package leetcode.middle.trans;

public class RomanToInteger {
    public int romanToInt(String s) {
        String romans = "IVXLCDM";
        int[] ints = new int[]{1,5,10,50,100,500,1000};
        int total = 0;
        int backup = 0;
        int index = 10;
        for (int i = 0; i < s.length();i++){
            int temp = romans.indexOf(s.charAt(i));
            if (temp < index){
                total += backup;
                backup = 0;
                backup += ints[temp];
                index = temp;
            }else if (temp == index){
                backup += ints[index];
            } else {
                total += (ints[temp]-backup);
                backup = 0;
                index = temp;
            }
        }
        return total+backup;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }
}
