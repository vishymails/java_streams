package eu.timepit.java8.stream.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * First look at streams
 */
public class S01Intro {
    public static void main(String[] args) {
        final List<Integer> list = Arrays.asList(1, 2, 3);
        list.stream().forEach(System.out::println);

        final IntStream one = IntStream.of(1);
        final int sum = one.sum();
        System.out.println("one.sum(): " + sum);

        final IntStream range = IntStream.range(1, 101);
        final int sum1 = range.sum();
        System.out.println("range.sum(): " + sum1);

        final IntStream nats = IntStream.iterate(1, i -> i + 1);
        //final int sum2 = nats.sum(); // terminiert nicht; heizt die CPU
        final int sum2 = nats.limit(100).sum();
        System.out.println("nats.limit(100).sum(): " + sum2);
    }
}
