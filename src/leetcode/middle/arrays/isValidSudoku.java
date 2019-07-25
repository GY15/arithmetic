package leetcode.middle.arrays;

import java.util.HashSet;
import java.util.Set;

public class isValidSudoku {

    // 判断数独是否合法，即将数字加入到对应的行，列，块中
    // 这里使用hashset的技巧，如果可以加入，则继续，一旦存在相同的数，则
    public boolean isValidSudoku(char[][] board) {
        Set row = new HashSet();
        Set column = new HashSet();
        Set block = new HashSet();

        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!row.add(number + " " + i) ||
                            !column.add(number + " " + j) ||
                            !block.add(number + " " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }
}
