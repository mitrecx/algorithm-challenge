package cn.mitrecx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class LeetCode57 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int newInterval[] = {2, 5};
        LeetCode57 leetCode57 = new LeetCode57();
        int[][] results = leetCode57.insert(intervals, newInterval);
        for (int[] r : results) {
            Arrays.stream(r).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] allIntervals = Arrays.copyOf(intervals, intervals.length + 1);
        allIntervals[intervals.length] = newInterval;
        return merge(allIntervals);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
                merged.add(new int[]{left, right});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
