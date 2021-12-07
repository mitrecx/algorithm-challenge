package cn.mitrecx.practice.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTest2 {
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

        System.out.println(
                Stream.of(1, 2, 3, 4, 5).parallel().reduce(0, (a, b) -> a + 2 * b)
        );
        System.out.println("================");

        System.out.println(
                Stream.of(1, 2, 3, 4, 5).parallel().reduce(0,
                        (a, b) -> {
                            System.out.println(Thread.currentThread().getName() + " " + a + " + " + (2 * b) + " = " + (a + 2 * b));
                            return a + 2 * b;
                        },
                        (a, b) -> {
                            System.out.println(
                                    "======================= "+ Thread.currentThread().getName() + " " + a + " " + b
                            );
                            return a + b;
                        })
        );

    }
}
