package cn.mitrecx;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {


    public static void main(String[] args) {
        LeetCode40 leetCode40 = new LeetCode40();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};

        int target = 8;
        List<List<Integer>> r = leetCode40.combinationSum2(candidates, target);
        for (List<Integer> e : r) {
            System.out.println(e);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);

        // 下标 0: 元素, 1: 元素个数
        List<int[]> freq = new ArrayList<int[]>();

        for (int e : candidates) {
            if (freq.isEmpty() || e != freq.get(freq.size() - 1)[0]) {
                freq.add(new int[]{e, 1});
            } else {
                freq.get(freq.size() - 1)[1]++;
            }
        }

        dfs(result, combine, freq, 0, target);

        return result;
    }

    private void dfs(List<List<Integer>> result,
                     List<Integer> combine,
                     List<int[]> freq,
                     int index,
                     int target) {
        if (target == 0) {
            result.add(new ArrayList<>(combine));
            return;
        }

        if (index >= freq.size() || target < freq.get(index)[0]) {
            return;
        }

        // 跳过当前元素, 遍历后一个元素
        dfs(result, combine, freq, index + 1, target);

        // 可重复元素的次数
        int most = Math.min(target / freq.get(index)[0], freq.get(index)[1]);
        for (int i = 1; i <= most; i++) {
            combine.add(freq.get(index)[0]);
            // 获取当前元素, 并遍历后一个元素
            dfs(result, combine, freq, index + 1, target - i * freq.get(index)[0]);
        }

        for (int i = 1; i <= most; i++) {
            combine.remove(combine.size() - 1);
        }
    }
}
