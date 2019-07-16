package advanced.course.p3.optionalAPI;

import java.util.Optional;

public class F1OptionalUsage {

    public static void main(String[] args) {
        String str = Optional.of("Hello")
                .map(String::toUpperCase)
                .get();
    }
}
