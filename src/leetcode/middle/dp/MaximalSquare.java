package leetcode.middle.dp;

import java.util.Stack;

public class MaximalSquare {
    //221
    public static void main(String[] args) {
        new MaximalSquare().maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
    public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (i == 0){
                    matrix[i][j] -= '0';
                }else{
                    if (matrix[i][j] == '1'){
                        matrix[i][j] = (char)(matrix[i-1][j] + 1);
                    }else {
                        matrix[i][j] = 0;
                    }
                }
            }
            maxArea = Math.max(largestInLine(matrix[i]),maxArea);
        }
        return maxArea;
    }
    public int largestInLine(char[] height) {
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++){
            int h = i == len ? 0 : height[i];
            if (s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                int bdgt = Math.min(s.empty()?i:i - s.peek() - 1, height[tp]);
                maxArea = Math.max(maxArea, bdgt*bdgt);
                i--;
            }
        }
        return maxArea;
    }
}
