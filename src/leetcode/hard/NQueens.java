package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
    }
    public List<List<String>> solveNQueens(int n) {
        int[][] queens = new int[n][n];
        List<List<String>> res =new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solveNextLine(queens,0,list,res);

        return res;
    }
    private void solveNextLine(int[][] queens, int n,List<Integer> list,  List<List<String>> res) {
        for (int i = 0; i < queens.length; i++){
            if (0==queens[n][i]){
                list.add(i);
                reverse(queens,n,i,1);
                if (n==queens.length-1){
                    List<String> strings =new ArrayList<>();
                    for (int j = 0;j<list.size();j++){
                        String s ="";
                        for (int k = 0;k<queens.length;k++){
                            if (k==list.get(j)){
                                s+="Q";
                            }else{
                                s+=".";
                            }
                        }
                        strings.add(s);
                    }
                    res.add(strings);
                }else{
                    solveNextLine(queens,n+1,list,res);
                }
                list.remove(n);
                reverse(queens,n,i,-1);
            }
        }
    }
    private void reverse(int[][] queens,int i,int j,int add){
        int i1=i;
        int j1=j;
        queens[i][j]-= (2*add);
        for (int i2 = i;i2<queens.length;i2++){
            queens[i2][j]+=add;
        }

        while(j1>=0&&i1<queens.length){
            queens[i1][j1]+=add;
            i1++;
            j1--;
        }
        while(i<queens.length && j<queens.length){
            queens[i][j]+=add;
            i++;
            j++;
        }
    }
}
