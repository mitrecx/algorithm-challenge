package cn.mitrecx;

public class LeetCode36 {
    public static void main(String[] args) {
        LeetCode36 leetCode36 = new LeetCode36();
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

        System.out.println(leetCode36.isValidSudoku(board));
    }

    // 因为 board 里的数字只有 9 个(1-9), 所以可以使用 board 里的数作为作为数组下标.
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subBoards = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = '.';
                if ((value = board[i][j]) != '.') {
                    // value ∈ [1,9]
                    int index = value - '0' - 1;
                    // 行
                    rows[i][index] += 1;
                    // 列
                    columns[j][index] += 1;
                    // 小九宫格
                    subBoards[i / 3][j / 3][index] += 1;

                    if (rows[i][index] > 1
                            || columns[j][index] > 1
                            || subBoards[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
