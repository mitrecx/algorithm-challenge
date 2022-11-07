package cn.mitrecx.leetcode1_200;

/**
 * Title: 134. Gas Station
 * Difficulty: Medium
 * Self Difficulty:
 * kw: 数学推导, 分析
 */
public class LeetCode134 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        LeetCode134 leetCode134 = new LeetCode134();
        System.out.println(leetCode134.canCompleteCircuit(gas, cost));
    }

    // 忽略严格的证明, 这里简单说明下解题思路:
    // 从当前位置A出发, 如果可以走完一圈, 就找到答案了;
    // 但如果走到某个位置B, 油量小于0了, 那说明 [A, B) 之间的所有位置出发都不可能是答案,
    // 因为在B之前的任意位置X油箱都是>0的, 任意位置之前的位置X-1油箱也是大于0的,说明从任意位置X(当前油量为0)出发, 油量都是小于X-1(当前油量大于0)位置的,
    // 所以, 如果A不符合, 则 [A, B) 之间的所有位置 都不符合
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGasLeft = 0, start = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            int gasLeft = gas[i] - cost[i];
            if (sumGasLeft >= 0) {
                sumGasLeft += gasLeft;
            } else {
                sumGasLeft = gasLeft;
                start = i;
            }
            total += gasLeft;
        }
        if (total >= 0) {
            return start;
        }
        return -1;
    }
}
