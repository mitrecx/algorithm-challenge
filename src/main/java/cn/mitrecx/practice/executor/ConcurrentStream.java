package cn.mitrecx.practice.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ConcurrentStream {
    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();
        lists.add(4);
        lists.add(3);
        lists.add(6);
        lists.add(1);
        lists.add(5);
        lists.add(2);

        //看看List里面的数据是什么样子的先
        System.out.print("List里面的数据:");
        for (Integer elem : lists) System.out.print(elem + " ");// 4 3 6 1 5 2

        //最小值
        System.out.print("List中最小的值为:");
        Stream<Integer> stream = lists.stream();
        Optional<Integer> min = stream.min(Integer::compareTo);
        if (min.isPresent()) {
            System.out.println(min.get());//1
        }
    }
}
