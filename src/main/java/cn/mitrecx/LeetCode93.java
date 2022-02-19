package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 93. Restore IP Addresses
 * Difficulty: Medium
 * Self Difficulty:
 * kw: 回溯
 */
public class LeetCode93 {


    public static void main(String[] args) {
        LeetCode93 leetCode93 = new LeetCode93();
        List<String> r = leetCode93.restoreIpAddresses("25525511135");
        r.forEach(System.out::println);
    }
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();

    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segIdx, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segIdx == SEG_COUNT) {
            if (segStart == s.length()) {
                ans.add(String.format("%d.%d.%d.%d", segments[0], segments[1], segments[2], segments[3]));
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segIdx] = 0;
            dfs(s, segIdx + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segIdx] = addr;
                dfs(s, segIdx + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
