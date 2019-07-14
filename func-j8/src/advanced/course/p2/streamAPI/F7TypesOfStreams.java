package advanced.course.p2.streamAPI;

import java.util.stream.Stream;

public class F7TypesOfStreams {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5);
        Stream.iterate(1, (prev) -> prev + 1);

        Stream.of(1, 2, 3, 4, 5).parallel();
    }
}
