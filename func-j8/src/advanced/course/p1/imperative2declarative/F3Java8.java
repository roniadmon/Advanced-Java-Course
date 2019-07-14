package advanced.course.p1.imperative2declarative;

import java.util.Arrays;
import java.util.List;

public class F3Java8 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");

        strings.forEach(str -> System.out.println(str));

        strings.forEach(System.out::println);
    }
}
