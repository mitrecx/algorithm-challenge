package cn.mitrecx.leetcode1_200;

/**
 * 79. Word Search
 * medium
 * 回溯 + 剪枝
 */
public class LeetCode79 {

    int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        LeetCode79 leetCode79 = new LeetCode79();
        System.out.println(leetCode79.exist(board, "ABCCED"));
        System.out.println(leetCode79.exist(board, "SEE"));
        System.out.println(leetCode79.exist(board, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length, columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boolean r = check(board, visited, i, j, word, 0);
                if (r) {
                    return true;
                }
            }
        }
        return false;
    }

    // check(i, j, k) 表示 从 (i,j) 位置出发, 能否搜索到 word[k...];
    // check(i, j, k) 的答案依赖于 check(nextI, nextJ, k+1), 以此类推.
    // 注: word[k...] 表示 word 从第k个字符到结尾
    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        for (int[] direction : directions) {
            int nextI = i + direction[0], nextJ = j + direction[1];
            if (nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length) {
                if (!visited[nextI][nextJ]) {
                    boolean flag = check(board, visited, nextI, nextJ, word, k + 1);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}
