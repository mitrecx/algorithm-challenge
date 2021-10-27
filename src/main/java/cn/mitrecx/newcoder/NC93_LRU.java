package cn.mitrecx.newcoder;

import java.util.*;

public class NC93_LRU {
    public int[] LRU(int[][] operators, int k) {
        // write code here
        Map<Integer, Integer> cache = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> r = new ArrayList<>();
        for (int[] operator : operators) {
            int opt = operator[0];
            if (opt == 1) {
                if (queue.size() == k) {
                    int last = queue.poll();
                    cache.remove(last);
                }
                queue.offer(operator[1]);
                cache.put(operator[1], operator[2]);
            } else if (opt == 2) {
                Integer cacheValue = cache.get(operator[1]);
                if(cacheValue != null){
                    r.add(cacheValue);
                    queue.remove(operator[1]);
                    queue.offer(operator[1]);
                } else {
                    r.add(-1);
                }
            }
        }
        int[] res = new int[r.size()];
        for (int i = 0; i < r.size(); i++) {
            res[i] = r.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        NC93_LRU nc93_lru = new NC93_LRU();
        int[][] req = {{1,1,1},{1,2,2},{2,1},{1,3,3},{2,2},{1,4,4},{2,1},{2,3},{2,4}};
        int k = 2;
        int res[] = nc93_lru.LRU(req, k);
        for(int i : res){
            System.out.println(i);
        }
    }
}
