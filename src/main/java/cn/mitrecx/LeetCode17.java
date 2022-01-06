package cn.mitrecx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {

    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations("23"));
    }

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    private ArrayList<String> res;


    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        if (digits.equals(""))
            return res;
        // 深度优先, 递归
        backtrack(digits, 0, "");

        return res;
    }

    /**
     * @param digits 数字数组
     * @param index  当前处理的数字的下标
     * @param s      回溯字符串, 初始化为空, 后面会组成全局解的一个元素
     */
    private void backtrack(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        char c = digits.charAt(index);

        String letters = letterMap[c - '0'];

        for (int i = 0; i < letters.length(); i++) {
            backtrack(digits, index + 1, s + letters.charAt(i));
        }

    }

}
