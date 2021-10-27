package cn.mitrecx.newcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuaWeiTopN {
    public static void topN(List<String> inputs) {
//        List<String> top = new ArrayList<>(10);
        Map<String, Integer> map = new HashMap<>();
        List<String> countUrls = new ArrayList<>();
        for (String input : inputs) {
            if (isNum(input)) {
                map.forEach((k, v) ->
                        countUrls.add(v + "_" + k)
                );
                countUrls.sort((v1, v2) -> Integer.parseInt(v1.split("_")[0]) > Integer.parseInt(v2.split("_")[0]) ? -1 : 1);
                int n = Integer.parseInt(input);
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(countUrls.get(i).split("_")[1] + ",");
                }
                System.out.println(countUrls.get(n - 1).split("_")[1]);
            } else {
                map.merge(input, 1, Integer::sum);
            }
        }

    }

    public static boolean isNum(String s) {
        if (s.length() > 2) {
            return false;
        } else if (s.length() == 1) {
            // 48(0), 57(9)
            if (48 <= s.charAt(0) && s.charAt(0) <= 57) {
                return true;
            }
            return false;
        } else if (s.length() == 2) {
            if (49 == s.charAt(0) && s.charAt(1) == 48) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(isNum("9"));
//        System.out.println(isNum("2"));
//        System.out.println(isNum("10"));
//        System.out.println(isNum("a"));
        List<String> list = new ArrayList<>();
        list.add("news.qq.com");
        list.add("news.sina.com.cn");
        list.add("news.qq.com");
        list.add("news.qq.com");
        list.add("game.163.com");
        list.add("game.163.com");
        list.add("www.huawei.com");
        list.add("www.cctv.com");
        list.add("3");
        topN(list);
    }
}
