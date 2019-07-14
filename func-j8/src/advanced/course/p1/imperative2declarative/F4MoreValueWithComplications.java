package advanced.course.p1.imperative2declarative;

import java.util.Arrays;
import java.util.List;

public class F4MoreValueWithComplications {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        doImperative(integers);

        doDeclarative(integers);
    }

    private static void doImperative(List<Integer> integers) {
        for (Integer i : integers) {
            if (i > 3) {
                System.out.println(i * 2);
            }
        }
    }

    private static void doDeclarative(List<Integer> integers) {
        integers.stream()
                .filter(i -> i > 3)
                .map(i -> i * 2)
                .forEach(System.out::println);
    }
}
