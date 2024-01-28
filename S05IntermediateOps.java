package eu.timepit.java8.stream.examples;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Intermediate operations
 */
public class S05IntermediateOps {
    static Stream<Integer> stream1() {
        return Stream.of(1, 2, 3);
    }

    static <T> void printStream(String desc, Stream<T> s) {
        System.out.println(desc + ": " + s.collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        // nützliche Methoden in Stream, die ein Stream modifizieren (intermediate operations):
        // diese Methoden sind immer lazy und führen keine Operationen aus

        // stateful: alle Elemente müssen in einem Set gespeichert werden
        final Stream<Integer> ex11 = Stream.of(1, 2, 1, 3, 2, 4).distinct();
        printStream("distinct", ex11);

        final Stream<Integer> ex03 = stream1().filter(i -> !i.equals(2));
        printStream("filter", ex03);

        final Stream<Integer> ex04 = stream1().flatMap(i -> Stream.of(i - 1, i, i + 1));
        printStream("flatMap", ex04);

        final Stream<Integer> ex07 = stream1().map(i -> i * i);
        printStream("map", ex07);

        final Stream<Integer> ex08 = stream1().peek(System.out::println);
        printStream("peek", ex08);

        final Stream<Integer> ex09 = stream1().skip(2);
        printStream("skip", ex09);

        // sorted ist stateful. Alle Elemente müssen angeschaut werden bevor sorted Elemente weiterreichen kann.
        final Stream<Integer> ex10 = Stream.of(4, 1, 5, 2).sorted();
        printStream("sorted", ex10);
    }
}
