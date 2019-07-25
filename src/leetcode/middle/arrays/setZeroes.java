package leetcode.middle.arrays;

public class setZeroes {
    public void setZeroes(int[][] matrix) {

        for (int i = 0; i < matrix.length;i++){
            for (int j = 0; j < matrix[0].length;j++){
                if (matrix[i][j]==-100){
                    matrix[i][j]=0;
                    continue;
                }
                if (matrix[i][j]==0) {
                    for (int k = 0;k<matrix[0].length;k++){
                        if (k<=j){
                            matrix[i][k] = 0;
                        }else{
                            if (matrix[i][k]!=0) {
                                matrix[i][k] = -100;
                            }
                        }
                    }
                    for (int k = 0;k<matrix.length;k++){
                        if (k<=i){
                            matrix[k][j] = 0;
                        }else{
                            if (matrix[k][j]!=0) {
                                matrix[k][j] = -100;
                            }
                        }
                    }

                }
            }
        }


    }
}
