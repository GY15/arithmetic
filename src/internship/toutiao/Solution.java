package internship.toutiao;
//
//有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9 的数字，不同字符映射为不同的数字。这样每个字符串就可以看做一个整数，唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？
//        输入描述:每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ， 接下来有 n 行，每行一个长度不超过 12 且仅包含大写字母 A-J 的字符串。 n 不大于 50，且至少存在一个字符不是任何字符串的首字母。
//        输出描述:输出一个数，表示最大和是多少。
//        输入例子:
//        2
//        ABC
//        BCA
//        输出例子:
//        1875
import java.util.*;

/**
 * Created by 61990 on 2017/10/19.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int weight[] = new int[10];
        char chars[]= new char[]{'A','B','C','D','E','F','G','H','I','G'};
        for (int l = 0; l<n+1;l++){
            String line = in.nextLine();
            if(line==null){

            }else{
                for (int i = 0,j = line.length(); i < line.length();i++,j-- ){
                    weight[getIndex(chars,line.charAt(i))] += Math.pow(10,j-1);
                }
            }
        }
        Arrays.sort(weight);
        int total =0;
        for (int i = 0 ; i< weight.length;i++){
            total+=weight[i]*i;
        }
        System.out.println(total);
    }

    private static int getIndex(char[] chars,char c){
        for (int i = 0; i< chars.length;i++){
            if (c == chars[i]){
                return i;
            }
        }
        return 0;
    }
}