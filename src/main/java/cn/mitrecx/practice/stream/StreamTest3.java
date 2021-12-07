package cn.mitrecx.practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamTest3 {

    public static void main(String[] args) {
        List<String> lists = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
        lists.stream().spliterator().forEachRemaining(System.out::println);
        System.out.println("===========");
        lists.stream().iterator();

        Spliterator<String> spliterator = lists.stream().spliterator();

        while (true) {
            if (!spliterator.tryAdvance(System.out::println)) break;
        }
    }
}
