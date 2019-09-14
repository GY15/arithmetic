package leetcode.middle.arrays;

public class NumMatrix {
    public static void main(String[] args) {
        int i = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
    {1, 0, 3, 0, 5}
        }).sumRegion(2,1,4,3);
         System.out.println(i);
    }
    int[][] m ;
    public NumMatrix(int[][] matrix) {
        m = matrix;
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                if (i == 0 && j==0){
                    continue;
                }
                if(i != 0 && j != 0){
                    m[i][j] = matrix[i][j] + m[i-1][j] + m[i][j-1] - m[i-1][j-1];
                }else if(i == 0){
                    m[i][j] = matrix[i][j] + m[i][j-1];
                }else if(j == 0){
                    m[i][j] = matrix[i-1][j] + m[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int num1 = row1>0?  m[row1-1][col2] :0;
        int num2 = col1>0? m[row2][col1-1] :0;
        int num3 = row1>0 && col1 > 0? m[row1-1][col1-1] :0;
        return m[row2][col2] - num1 - num2 +num3 ;
    }
}
