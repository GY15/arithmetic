package leetcode.middle.arrays;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid.length == 0) {
            return num;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dissolve(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void dissolve(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dissolve(grid, i-1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dissolve(grid, i, j-1);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            dissolve(grid, i+1, j);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            dissolve(grid, i, j+1);
        }
    }
}
