package leetcode.hard;

public class longestIncreasingPath {
    public static void main(String[] args) {
        new longestIncreasingPath().longestIncreasingPath(new int[][]{{3,2,3,4},{5,1,7,6}});
    }
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length;i++){
            for (int j = 0; j < matrix[0].length;j++){
                if (res[i][j] == 0)
                    res[i][j] = getMax(matrix,i,j,res);
            }
        }
        return m;
    }
    int m = 0;
    private int getMax(int[][] matrix, int i, int j,int res[][]) {
        int max = 1;
        if (i > 0 && matrix[i-1][j] < matrix[i][j]){
            if (res[i-1][j] == 0){
                max = Math.max(getMax(matrix ,i-1,j,res) + 1,max);
            } else {
                max = Math.max(max,res[i-1][j] + 1);
            }
        }
        if (j > 0 && matrix[i][j-1] < matrix[i][j] ){
            if (res[i][j-1] == 0){
                max = Math.max(getMax(matrix, i,j - 1, res) + 1,max);
            }else {
                max = Math.max(max,res[i][j - 1] + 1);
            }
        }
        if (j < matrix[0].length - 1 && matrix[i][j+1] < matrix[i][j] ){
            if (res[i][j + 1] == 0){
                max = Math.max(getMax(matrix, i,j + 1, res) + 1,max);
            }else {
                max = Math.max(max,res[i][j + 1] + 1);
            }
        }
        if (i < matrix.length - 1 && matrix[i+1][j] < matrix[i][j] ){
            if (res[i+1][j] == 0){
                max = Math.max(getMax(matrix, i+1,j, res) + 1,max);
            }else {
                max = Math.max(max,res[i + 1][j] + 1);
            }
        }
        res[i][j] = max;
        if (m < res[i][j]){
            m = res[i][j];
        }
        return max;
    }
}
