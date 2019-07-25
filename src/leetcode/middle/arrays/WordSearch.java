package leetcode.middle.arrays;

public class WordSearch {
    public static void main(String[] args) {
        new WordSearch().exist(
                new char[][]{
                        {'A', 'B', 'C', 'E'},{'B', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}
                },"ABABC"
        );
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j]==word.charAt(0)) {
//                    char c= board[i][j];
//                    board[i][j] = ' ';
                    if(findNext(board, word, i, j, 0)){
                        return true;
                    }
//                    board[i][j] = c;
                }
            }
        }
        return false;
    }
    public boolean findNext(char[][] board,String word,int i, int j, int index){
        if (board[i][j]==word.charAt(index)) {
            if (index == word.length()-1){
                return true;
            }
            char c= board[i][j];
            board[i][j] = ' ';
            if (i-1>=0){
                if(findNext(board, word, i-1, j, index+1)){
                    return true;
                }
            }
            if (i+1<board.length){
                if(findNext(board, word, i+1, j, index+1)){
                    return true;
                }
            }
            if (j-1>=0){
                if(findNext(board, word, i, j-1, index+1)){
                    return true;
                }
            }
            if (j+1<board[0].length){
                if(findNext(board, word, i, j+1, index+1)){
                    return true;
                }
            }
            board[i][j] = c;
            return false;
        }else{
            return false;
        }
    }
}