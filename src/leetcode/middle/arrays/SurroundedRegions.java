package leetcode.middle.arrays;

public class SurroundedRegions {
    public void solve(char[][] board) {
        for (int j = 0; j < board[0].length;j++){
            if (board[0][j] == 'O'){
                change(board,0,j);
            }
            if (board[board.length-1][j] == 'O'){
                change(board,board.length-1,j);
            }
        }
        for (int i = 1 ; i < board.length-1;i++){
            if (board[i][0] == 'O'){
                change(board,i,0);
            }
            if (board[i][board[0].length-1] == 'O'){
                change(board,i,board[0].length-1);
            }
        }

        for (int i = 0;i < board.length;i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'V'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void change(char[][] board,int x, int y){
        board[x][y] = 'V';
        if (x+1 < board.length && board[x+1][y] == 'O'){
            change(board,x+1,y);
        }
        if (x-1 >= 0 && board[x-1][y] == 'O'){
            change(board,x-1,y);
        }
        if (y+1 < board[0].length && board[x][y+1] == 'O'){
            change(board,x,y+1);
        }
        if (y-1 >= 0 && board[x][y-1] == 'O'){
            change(board,x,y-1);
        }
    }

    public static void main(String[] args) {
        new SurroundedRegions().solve(new char[][]{{'O'}});
    }
}
