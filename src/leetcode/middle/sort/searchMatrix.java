package leetcode.middle.sort;

public class searchMatrix {
    public static void main(String[] args) {
        new searchMatrix().searchMatrix(new int[][]{
                        {1,   3,  5,  7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                        }
                        ,7);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int begin = 0;
        int end = matrix.length;
        while(begin<end){
            int mid = (begin+end)/2;
            if (matrix[mid][0] == target){
                return true;
            }else if (matrix[mid][0] < target){
                if (mid == matrix.length-1 || matrix[mid+1][0]>target){
                    begin = mid;
                    break;
                }
                begin = mid;
            }else{
                end = mid;
            }
        }
        int start = 0;
        end = matrix[0].length;
        while(start<end){
            int mid = (start+end)/2;
            if (matrix[begin][mid] == target){
                return true;
            }else if (matrix[begin][mid] > target){
                end = mid;
            }else{
                if (mid==matrix[0].length-1|| matrix[begin][mid+1] > target){
                    break;
                }
                start = mid;
            }
        }
        return false;
    }
}
