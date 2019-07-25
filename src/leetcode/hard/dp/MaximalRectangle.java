package leetcode.hard.dp;

import java.util.Stack;

/*
* Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

    Example:
    Input:
    [
      ["1","0","1","0","0"],
      ["1","0","1","1","1"],
      ["1","1","1","1","1"],
      ["1","0","0","1","0"]
    ]
    Output: 6
* */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++){
            if (i == 0){
                for (int j = 0; j < matrix[0].length;j++) {
                    matrix[0][j] -= '0';
                }
            }else {
                for (int j = 0; j < matrix[i].length;j++) {
                    if (matrix[i][j] == '1') {
                        matrix[i][j] = (char) (matrix[i-1][j]+1);
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }
            max = Math.max(max, largestInLine(matrix[i]));
        }
        return max;
    }
    public int largestInLine(char[] height) {
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
