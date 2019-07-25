package leetcode.hard;

import java.util.Arrays;

//解决数独，从第一个空开始依次的到最后一个，依次将.对应的可以填入的数据填入，看这条路能不能走通，如果不能把该点重置为.并返回false
public class solveSudoku {
        public void solveSudoku(char[][] board) {
            dfs(board,0);
        }
        private boolean dfs(char[][] board, int d) {
            if (d==81) return true; //found solution
            int i=d/9, j=d%9;
            if (board[i][j]!='.') return dfs(board,d+1);//prefill number skip

            boolean[] flag=new boolean[10];
            validate(board,i,j,flag);
            for (int k=1; k<=9; k++) {
                if (flag[k]) {
                    board[i][j]=(char)('0'+k);
                    if (dfs(board,d+1)) return true;
                }
            }
            board[i][j]='.'; //if can not solve, in the wrong path, change back to '.' and out
            return false;
        }
        private void validate(char[][] board, int i, int j, boolean[] flag) {
            Arrays.fill(flag,true);
            for (int k=0; k<9; k++) {
                if (board[i][k]!='.') flag[board[i][k]-'0']=false;
                if (board[k][j]!='.') flag[board[k][j]-'0']=false;
                int r=i/3*3+k/3;
                int c=j/3*3+k%3;
                if (board[r][c]!='.') flag[board[r][c]-'0']=false;
            }
    }
}
