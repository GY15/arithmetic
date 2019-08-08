package leetcode.hard.dp;

public class DungeonGame {
    //174
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon[dungeon.length-1][dungeon[0].length - 1] >= 0){
            dungeon[dungeon.length-1][dungeon[0].length - 1]  = 1;
        }else{
            dungeon[dungeon.length-1][dungeon[0].length - 1]  =  -dungeon[dungeon.length-1][dungeon[0].length - 1] + 1;
        }
        for (int i = dungeon.length-2; i >= 0; i--){
            dungeon[i][dungeon[0].length-1] = Math.max(1,dungeon[i+1][dungeon[0].length-1]-dungeon[i][dungeon[0].length-1]);
        }
        for (int j = dungeon[0].length-2; j >= 0; j--){
            dungeon[dungeon.length-1][j] = Math.max(1,dungeon[dungeon.length-1][j+1]-dungeon[dungeon.length-1][j]);
        }
        for(int i = dungeon.length-2; i >= 0; i--){
            for (int j = dungeon[0].length - 2; j >= 0; j--){
                dungeon[i][j] = Math.min(dungeon[i+1][j] - dungeon[i][j],dungeon[i][j+1] - dungeon[i][j]);
                if (dungeon[i][j]<= 0){
                    dungeon[i][j] = 1;
                }
            }
        }
        return dungeon[0][0];
    }
}
