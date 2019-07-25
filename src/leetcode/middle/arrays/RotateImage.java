package leetcode.middle.arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] num = new int[][]{
                {5,1,9,11},{2,4,8,10},{13,3,6,7},{15 ,14,12,16}
        };
        new RotateImage().rotate(num);
    }
    public void rotate(int[][] matrix) {
        for (int i = 0;i < matrix.length/2;i++){
            int size = matrix.length-1;
            for (int j = i;j<matrix[0].length-i-1;j++){
                int x = j;
                int y = size-i;
                int temp = matrix[x][y];
                matrix[x][y] = matrix[i][j];
                x = size-i;
                y = size-j;
                int temp2 = matrix[x][y];
                matrix[x][y] = temp;
                x = size-j;
                y = i;
                matrix[i][j] = matrix[x][y];
                matrix[x][y] = temp2;
            }
        }
    }
}
//00 01 02
//10 11 12
//20 21 22
//
//        00 01 02 03
//        10 11 12 13
//        20 21 22 23
//        30 31 32 33
