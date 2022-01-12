package cn.mitrecx;

public class LeetCode38 {
    public static void main(String[] args) {
        LeetCode38 leetCode38 = new LeetCode38();
        System.out.println(leetCode38.countAndSay(4));
    }

    public String countAndSay(int n) {
        String r = "1";

        for (int i = 2; i <= n; i++) {
            int pos = 0;
            int start = 0;
            // 统计本轮结果
            StringBuilder curr = new StringBuilder();
            while (pos < r.length()) {
                while (pos < r.length() && r.charAt(pos) == r.charAt(start)) {
                    pos++;
                }
                curr.append(pos - start).append(r.charAt(start));
                start = pos;
            }

            r = curr.toString();
        }

        return r;
    }
}
