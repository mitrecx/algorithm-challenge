package cn.mitrecx.practice.stream;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 2, 3, 4, 5).reduce((a, b) -> a + 2 * b).orElse(-1)
        );
        System.out.println(
                Stream.of(1, 2, 3, 4, 5).parallel().reduce((a, b) -> a + 2 * b).orElse(-1)
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5).reduce(0, (a, b) -> a + 2 * b)
        );
        ArrayList<Integer> newList = new ArrayList<>();
        Stream.of(1, 2, 3, 4, 5).reduce(
                newList, (acc, item) -> {
                    acc.add(item);
                    System.out.println("item: " + item);
                    System.out.println("acc+ : " + acc);
                    System.out.println("BiFunction");
                    return acc;
                }, (u1, u2) -> {
                    System.out.print("thread " + Thread.currentThread().getName());
                    u1.forEach(s -> System.out.print(s + " "));
                    System.out.println("---------");
                    u2.forEach(s -> System.out.print(s + " "));
                    System.out.println("===========");
                    return u1;
                });


    }
}
