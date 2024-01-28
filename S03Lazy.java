package eu.timepit.java8.stream.examples;

import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Streams try to be lazy
 */
public class S03Lazy {
    public static void main(String[] args) {
        IntPredicate isEven = i -> {
            System.out.println(i);
            return i % 2 == 0;
        };

        final OptionalInt first = IntStream.range(1, 10).filter(isEven).findFirst();
        System.out.println("evens.findFirst(): " + first);

        final int sum = IntStream.range(1, 10).filter(isEven).sum();
        System.out.println("evens.sum(): " + sum);
    }
}
