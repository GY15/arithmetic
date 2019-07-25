package leetcode.middle.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMetrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int m = 0;
        List<Integer> list = new ArrayList<>();
        while(left<=right&&top<=bottom){
            switch (m){
                case 0:
                    for (int i = left;i<=right;i++){
                        list.add(matrix[top][i]);
                    }
                    top++;
                    m=1;
                    break;
                case 1:
                    for (int i = top;i<=bottom;i++){
                        list.add(matrix[i][right]);
                    }
                    m=2;
                    right--;
                    break;
                case 2:
                    for (int i = right;i>=left;i--){
                        list.add(matrix[bottom][i]);
                    }
                    bottom--;
                    m=3;
                    break;
                case 3:
                    for (int i = bottom;i>=top;i--){
                        list.add(matrix[i][left]);
                    }
                    left++;
                    m=0;
                    break;
            }
        }
        return list;
    }
}
