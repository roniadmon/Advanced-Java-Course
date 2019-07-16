package advanced.course.p3.optionalAPI;

import java.util.Optional;
import java.util.function.Consumer;

public class F4OptionalExit {

    public static void main(String[] args) {
        Optional<Integer> optionalInteger = Optional.of(1);

        Integer get = optionalInteger.get();
        Integer orElse = optionalInteger.orElse(-1);
        Integer orElseGet = optionalInteger.orElseGet(() -> -1);
        Integer orElseThrow = optionalInteger.orElseThrow(() -> new RuntimeException());

        optionalInteger.ifPresent(integer -> {
            // do something
        });

        if (optionalInteger.isPresent()) {

        }
    }
}
