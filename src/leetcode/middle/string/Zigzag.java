package leetcode.middle.string;

public class Zigzag {
    //String竖着写之后横着读，弄一个指针往里面写
    public static void main(String[] args) {
        System.out.println(Zigzag.convert("AassB",2));
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        String[] group = new String[numRows];
        int index = 0;
        boolean increase = true;
        for (int i = 0; i < numRows;i++){
            group[i]="";
        }
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            group[index] += c;
            if (increase){
                index++;
            } else {
                index--;
            }
            if (index == numRows-1){
                increase = false;
            } else if (index == 0){
                increase = true;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows;i++){
            res.append(group[i]);
        }
        return res.toString();
    }
}
