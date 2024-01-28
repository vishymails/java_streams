/*
 * Copyright (c) 2015 - M-net Telekommunikations GmbH
 * All rights reserved.
 * -------------------------------------------------------
 * File created: 19.03.2015
 */
package eu.timepit.java8.stream.examples;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream generators / sources
 */
public class S04Generators {
    static Stream<Integer> stream1() {
        return Stream.of(1, 2, 3);
    }

    static Stream<Integer> stream2() {
        return Stream.of(4, 5, 6);
    }

    static <T> void printStream(String desc, Stream<T> s) {
        System.out.println(desc + ": " + s.collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        final Stream<Integer> ex01 = Stream.concat(stream1(), stream2());
        printStream("concat", ex01);

        final Stream<Object> ex02 = Stream.empty();
        printStream("empty", ex02);

        // limit ist stateful
        final Stream<Integer> ex05 = Stream.generate(() -> 1).limit(10);
        printStream("generate", ex05);

        final Stream<String> ex06 = Stream.iterate("", s -> s + "+").limit(10);
        printStream("iterate", ex06);

        IntStream.range(1, 100);

        /*
        - From a Collection via the stream() and parallelStream() methods;
        - From an array via Arrays.stream(Object[]);
        - The lines of a file can be obtained from BufferedReader.lines();
        - Streams of file paths can be obtained from methods in Files;
        - Streams of random numbers can be obtained from Random.ints();
        - Numerous other stream-bearing methods in the JDK, including BitSet.stream(),
          Pattern.splitAsStream(java.lang.CharSequence), and JarFile.stream().
        */
    }
}
