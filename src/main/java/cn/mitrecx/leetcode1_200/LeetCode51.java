package cn.mitrecx.leetcode1_200;

import java.util.*;

/**
 * 51. N-Queens
 *
 * queue 就相当于 中国象棋里的加强版的车, queue 可以走横竖两条直线, 还可以走两条对角线.
 * n 皇后问题需要穷举(遍历)找答案.
 * 穷举可以使用回溯算法.
 * <p>
 * 回溯的具体做法是:
 * 使用一个数组 queens[] 记录每行放置的皇后的列下标, 依次在每一行放置一个皇后.
 * 每次新放置的皇后都不能和已经放置的皇后之间有攻击:
 * 即新放置的皇后不能和任何一个已经放置的皇后在同一列以及同一条斜线上, 并更新数组中的当前行的皇后列下标.
 * 当 N 个皇后都放置完毕, 则找到一个可能的解.
 * <p>
 * 为了降低总时间复杂度, 每次放置皇后时需要快速判断每个位置是否可以放置皇后,
 * 显然, 最理想的情况是在 O(1) 的时间内判断该位置所在的列和两条斜线上是否已经有皇后.
 * <p>
 * 为了判断一个位置所在的列和两条斜线上是否已经有皇后, 使用三个 Set 集合
 * columns, diagonals, diagonals2 分别记录每一列以及两个方向的每条斜线上是否有皇后.
 * 这里有一个技巧:
 * 两条斜线上的所有元素可以分别用一个元素表示此条斜线是否被占用.
 * 左上到右下方向, 每个位置满足 行下标 与 列下标 之差 相等.
 * 右上到左下方向, 每个位置满足 行下标 与 列下标 之和 相等.
 * <p>
 * 作者: LeetCode-Solution
 * 链接: https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-by-leetcode-solution/
 * 来源: 力扣（LeetCode）
 * 著作权归作者所有. 商业转载请联系作者获得授权, 非商业转载请注明出处.
 */
public class LeetCode51 {
    public static void main(String[] args) {
        LeetCode51 leetCode51 = new LeetCode51();
        List<List<String>> results = leetCode51.solveNQueens(4);
        for (List<String> r : results) {
            for (String e : r) {
                System.out.println(e);
            }
            System.out.println();
        }
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        // 记录行 所选择放置 queue 的下标
        int[] queens = new int[n];
        // 也可以不用初始化
        // Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions,
                          int[] queens, int n, int row,
                          Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            int diagonal1 = row - i;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }
            queens[row] = i;
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
            // 可以不用重置
            // queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
