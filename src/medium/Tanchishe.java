package medium;

public class Tanchishe {
    public static void main(String[] args) {
        new Tanchishe().minimumMoves(new int[][]{
                {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}

        });
    }
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[][] heng = new int[n][n];
        int[][] shu = new int[n][n];

        if(n > 2 && grid[0][2] == 0){
            heng[0][1] = 1;
        }
        if(n > 1 && grid[1][0] == 0 && grid[1][1] == 0){
            heng[1][0] = 1;
            shu[0][0] = 1;
        }


        for (int i = 0; i < n; i++){
            for (int j = 0; j < n;j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if (grid[i][j] != 0){
                    continue;
                }
                int h = 1000000,s = 1000000;
                // handle heng
                if(j + 1 < n && grid[i][j+1] == 0) {
                    if (i - 1 >= 0 && heng[i - 1][j] != 0) {
                        h = Math.min(h, heng[i - 1][j]);
                    }
                    if (j - 1 >= 0 && heng[i][j - 1] != 0) {
                        h = Math.min(h, heng[i][j - 1]);
                    }
                }
                if(i + 1 < n && grid[i+1][j] == 0) {
                    if (i - 1 >= 0 && shu[i - 1][j] != 0) {
                        s = Math.min(s, shu[i - 1][j]);
                    }
                    if (j - 1 >= 0 && shu[i][j - 1] != 0) {
                        s = Math.min(s, shu[i][j - 1]);
                    }
                }
                if (i+1 < n && j+1<n &&grid[i+1][j] == 0 && grid[i][j+1] == 0 && grid[i+1][j+1]==0){
                    if (s != 1000000){
                        h = Math.min(h,s+1);
                    }
                    if (h != 1000000){
                        s = Math.min(s,h+1);
                    }
                }
                if (s != 1000000 && shu[i][j]==0) {
                    shu[i][j] = s + 1;
                }
                if (h != 1000000 && heng[i][j] == 0) {
                    heng[i][j] = h + 1;
                }
            }
        }
        return heng[n-1][n-2]== 0 ? -1:heng[n-1][n-2] ;
    }
}
