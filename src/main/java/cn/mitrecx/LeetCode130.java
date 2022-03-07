package cn.mitrecx;

/**
 * Title: 130. Surrounded Regions
 * Difficulty: Medium
 * Self Difficulty:
 * kw: dfs(深度优先搜索)
 */
public class LeetCode130 {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        System.out.println(board[1][1]);//O
        LeetCode130 leetCode130 = new LeetCode130();
        leetCode130.solve(board);
        System.out.println(board[1][1]);//X
    }
    int m, n; // m 行, n 列

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        // 首位两行
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        // 首位两列
        for (int i = 1; i < m - 1; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 对于每一个边界上的 O, 以它为起点, 标记所有与它直接或间接相连的字母 O.
     * 注: 这里直接将 O 改为 A 以标记.
     */
    private void dfs(char[][] board, int x, int y) {
        // 越界
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        // 不为 'O' 说明不连通
        if (board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
    }

}
