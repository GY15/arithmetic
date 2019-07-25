package leetcode.middle.dp;

public class UniquePaths {
    //能用dp的就不要用递归
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }else if (m == 2){
            return n;
        }else if (n == 2){
            return m;
        }else{
            return uniquePaths(m-1,n) + uniquePaths(m,n-1);
        }
    }
    public int uniquePath(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i==0||j==0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
    }

    //有障碍物怎么办
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        for (int i = 0; i < obstacleGrid.length; i++){
            for (int j = 0; j < obstacleGrid[0].length; j++){

                if (obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }else{
                    if (i==0){
                        if(j==0){
                            obstacleGrid[i][j] = 1;
                        }
                        obstacleGrid[i][j] = obstacleGrid[i][j-1];
                    } else if (j == 0) {
                        obstacleGrid[i][j] = obstacleGrid[i-1][j];
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                    }
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

}
