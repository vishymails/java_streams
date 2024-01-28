package eu.timepit.java8.stream.examples;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Terminal operations
 */
public class S06TerminalOps {
    public static void main(String[] args) {
        // Stream Pipeline wird erst durch eine terminal operation ausgeführt

        final boolean ex01 = Stream.of(1, 2, 3).allMatch(i -> i < 5); // und auch noneMatch
        System.out.println("allMatch: " + ex01);

        final boolean ex02 = Stream.of(1, 2, 3).anyMatch(i -> i.equals(4));
        System.out.println("anyMatch: " + ex02);

        final Set<Integer> ex03 = Stream.of(1, 2, 3).collect(Collectors.toSet());
        System.out.println("collect: " + ex03);

        final long ex04 = Stream.of(1, 2, 3).count();
        System.out.println("count: " + ex04);

        final Optional<Integer> ex05 = Stream.of(1, 2, 3).findAny();
        System.out.println("findAny: " + ex05);

        final Optional<Integer> ex06 = Stream.of(1, 2, 3).parallel().findAny();
        System.out.println("findAny parallel: " + ex06);

        final Optional<Integer> ex07 = Stream.of(1, 2, 3).findFirst();
        System.out.println("findFirst: " + ex07);

        Stream.of(1, 2, 3).forEach(System.out::println);

        final Optional<Integer> ex08 = Stream.of(1, 2, 3).max(Integer::compareTo); // und auch min
        System.out.println(ex08);

        final String ex09 = Stream.of("Hello", "World").reduce("", (s1, s2) -> s1 + s2);
        System.out.println("reduce: " + ex09);

        final Object[] ex10 = Stream.of("Hallo", "Welt").toArray();
        System.out.println(Arrays.toString(ex10));
    }
}
