package advanced.course.p2.streamAPI;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class F6Creation {

    private static int i = 1;

    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5).stream();
        Stream.of(1, 2, 3, 4, 5);
        Stream.generate(() -> i++);
        Stream.iterate(1, (prev) -> prev + 1);

        IntStream intStream = IntStream.rangeClosed(1, 5);

        Stream.concat(Stream.of(1, 2), Stream.of(3, 4));
    }


}
