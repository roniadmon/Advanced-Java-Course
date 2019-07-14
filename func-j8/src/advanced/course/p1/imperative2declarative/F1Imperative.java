package advanced.course.p1.imperative2declarative;

import java.util.Arrays;
import java.util.List;

public class F1Imperative {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }

    }
}
