package advanced.course.p1.imperative2declarative;

import java.util.Arrays;
import java.util.List;

public class F2Java7 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");

        for (String str : strings) {
            System.out.println(str);
        }

    }
}
