package leetcode.middle.arrays;

public class SpiralMatrix {
    /*
        Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order
    */
    public static void main(String[] args) {
        new SpiralMatrix().generateMatrix(3);
    }
    public int[][] generateMatrix(int n) {
        int now = 1;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < (n+1)/2; i++){
            if (n%2 == 1 && i ==n/2){
                matrix[i][i]=now;
                break;
            }

                    for (int j = i; j < n - i - 1; j++) {
                        matrix[i][j] = now;
                        now++;
                    }
                    for (int j = i; j < n - i - 1; j++) {
                        matrix[j][n-i-1] = now;
                        now++;
                    }
                    for (int j = n - i - 1; j > i; j--) {
                        matrix[n-i-1][j] = now;
                        now++;
                    }
                    for (int j = n - i - 1; j > i; j--) {
                        matrix[j][i] = now;
                        now++;
                    }
        }
        return matrix;
    }
}
