package advanced.course.p2.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class F1Basics {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> integerStream = integers.stream();
        Stream<Integer> filtered = integerStream.filter(i -> i > 3);
        Stream<String> stringStream = filtered.map(Object::toString);
        stringStream.forEach(System.out::println);

    }
}
