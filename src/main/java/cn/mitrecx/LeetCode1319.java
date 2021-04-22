package cn.mitrecx;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1319 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
        int n = 4;
        System.out.println(solution.makeConnected(4, connections));
    }

    static class Solution {
        public int makeConnected(int n, int[][] connections) {
            // 边数 至少等于 (节点数-1) 才有解
            if (connections.length < n - 1) {
                return -1;
            }
            if (n == 1) {
                return 0;
            }
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < connections.length; i++) {
                uf.merge(connections[i][0], connections[i][1]);
            }
            Set<Integer> roots = new HashSet<>();
            for (int i = 0; i < n; i++) {
                roots.add(uf.find(i));
            }
            return roots.size() - 1;
        }
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }

        public void merge(int i, int j) {
            // not parent[j] = find(i)
            parent[find(j)] = find(i);
        }
    }
}
