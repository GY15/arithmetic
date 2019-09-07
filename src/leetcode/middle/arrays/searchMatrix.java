package leetcode.middle.arrays;

public class searchMatrix {
    //240
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length;
        boolean firstTurn = false;
        while (true){
            if(j<0 || i > matrix.length){
                return false;
            }
            if (matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
    }
}
