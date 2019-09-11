package leetcode.middle.arrays;

public class gameOfLife {
    public static void main(String[] args) {
        new gameOfLife().gameOfLife(new int[][]{{ 0,1,0},
        {0,0,1},
        {1,1,1},
        {0,0,0}});
    }
    public void gameOfLife(int[][] board) {
        int curNeibor;

        for(int i = 0; i < board.length;i++){
            for (int j = 0; j < board[0].length;j++){
                curNeibor = 0;
                if(i!=0 && (board[i-1][j]==1 || board[i-1][j]==2)){
                    curNeibor += 1;
                }
                if(j!=0 && (board[i][j-1]==1 || board[i][j-1]==2)){
                    curNeibor += 1;
                }
                if(i!=board.length-1 && (board[i+1][j]==1 || board[i+1][j]==2)){
                    curNeibor += 1;
                }
                if(j!=board[0].length-1 && (board[i][j+1]==1 || board[i][j+1]==2)){
                    curNeibor += 1;
                }

                if(i!=0 && j!=0 && (board[i-1][j-1]==1 || board[i-1][j-1]==2)){
                    curNeibor += 1;
                }
                if(i!=0 && j!=board[0].length-1 && (board[i-1][j+1]==1 || board[i-1][j+1]==2)){
                    curNeibor += 1;
                }
                if(i!=board.length-1 && j!=0 && (board[i+1][j-1]==1 || board[i+1][j-1]==2)){
                    curNeibor += 1;
                }
                if(i!=board.length-1 && j!=board[0].length-1 && (board[i+1][j+1]==1 || board[i+1][j+1]==2)){
                    curNeibor += 1;
                }

                if(board[i][j] == 0){
                    if (curNeibor == 3){
                        board[i][j] = 3;
                    }
                }else{
                    if (curNeibor < 2 || curNeibor > 3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i = 0; i < board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2){
                    board[i][j] = 0;
                }else if (board[i][j]==3){
                    board[i][j] = 1;
                }
            }
        }
    }
}
