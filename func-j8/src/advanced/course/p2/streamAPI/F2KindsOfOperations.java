package advanced.course.p2.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class F2KindsOfOperations {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        // intermediate operations
        Stream<Integer> integerStream = integers.stream();
        Stream<Integer> filtered = integerStream.filter(i -> i > 3);
        Stream<String> stringStream = filtered.map(Object::toString);

        // terminal operations
        stringStream.forEach(System.out::println);
        List<String> collect = stringStream.collect(Collectors.toList());
        Optional<String> any = stringStream.findAny();







        Optional<String> reduce = stringStream.reduce((s1, s2) -> s1 + ", " + s2);
        String joining = stringStream.collect(Collectors.joining(", "));

    }
}
