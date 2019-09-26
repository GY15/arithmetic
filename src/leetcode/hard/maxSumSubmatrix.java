package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class maxSumSubmatrix {
    public static void main(String[] args) {
        new maxSumSubmatrix().maxSumSubmatrix(new int[][]{{2,2,-1}},0);
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length;i++){
            max = Math.max(max,getLargest(matrix[i],k));
            for (int j = i - 1; j >= 0; j--){
                for (int a = 0; a < matrix[0].length; a++){
                    matrix[j][a] += matrix[i][a];
                }
                max = Math.max(max,getLargest(matrix[j],k));
            }
        }
        return max;
    }
    public int getLargest(int arr[], int k){
        int res[] = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            res[i] = arr[i];
            if ( res[i] > max && res[i] <= k){
                max = res[i];
            }
            for (int j = i - 1; j >= 0; j--){
                res[j] += res[i];
                if ( res[j] > max && res[j] <= k){
                    max = res[j];
                }
            }
        }
        return max;
    }
}
