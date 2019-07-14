package advanced.course.p2.streamAPI;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class F8ErrorsWithTypeOfStreams {

    public static void main(String[] args) {
        // finite/infinite?
        Stream<Integer> finite = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> infinite = Stream.iterate(1, (prev) -> prev + 1);

        acceptStream(finite);
        acceptStream(infinite);

        // parallel/sequential
        Stream<Integer> parallel = Stream.iterate(1, (prev) -> prev + 1).parallel().limit(1000);

        acceptStream(parallel);


        // best practices:
        // 1. don't pass/accept streams
        // 2. if you have to, guard yourself (assume infinite, parallel)
        // 3. sometimes, you should still do it (lazy may be worth it) :)
    }

    private static void acceptStream(Stream<Integer> stream) {
        List<Integer> list = new LinkedList<>();
        stream.forEach(list::add);
        System.out.println(list);
    }


}
