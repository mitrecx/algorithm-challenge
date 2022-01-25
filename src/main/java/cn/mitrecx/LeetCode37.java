package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

/**
 * 37. Sudoku Solver
 */
public class LeetCode37 {

    public static void main(String[] args) {
        LeetCode37 leetCode37 = new LeetCode37();
        char[][] board = {
                /*'8'*/
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        leetCode37.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    // 行, 数独元素值-1
    private final boolean[][] row = new boolean[9][9];
    // 列, 数独元素值-1
    private final boolean[][] column = new boolean[9][9];
    // 九宫格位置([0,0]->[2,2]), 数独元素值-1
    private final boolean[][][] block = new boolean[3][3][9];
    // 空白格的位置, int[] 只存2个元素---行和列的下标
    private final List<int[]> spaces = new ArrayList<>();
    // 标记找到解, 如果找到解的话就不用再递归了
    private boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int index = board[i][j] - '0' - 1;
                    row[i][index] = column[j][index] = block[i / 3][j / 3][index] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        // 空白格: 从 1->9 尝试
        for (int index = 0; index < 9 && !valid; index++) {
            if (!row[i][index] && !column[j][index] && !block[i / 3][j / 3][index]) {
                row[i][index] = column[j][index] = block[i / 3][j / 3][index] = true;
                // 存下来(可覆盖)
                board[i][j] = (char) (index + '0' + 1);
                dfs(board, pos + 1);
                // 如不是解, 清除本次填的数
                row[i][index] = column[j][index] = block[i / 3][j / 3][index] = false;
            }
        }
    }
}
