package advanced.course.p1.unexpected;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class F6FixingWithOptional {
    public Optional<Integer> numberOfFriends(String userId) {
        return Optional.of(userId)
                .map(MockDB::getUserById)
                .map(MockDB.User::getFriends)
                .map(List::size);
    }

    public static void main(String[] args) {
        Stream
                .of("Marco", "Polo", "Other")
                .forEach(
                        userId -> {
                            Optional<Integer> optional = new F6FixingWithOptional().numberOfFriends(userId);
                            if (optional.isPresent()) {
                                Integer numberOfFriends = optional.get();
                                System.out.println(userId + " has " + numberOfFriends + " friends!");
                            } else {
                                System.out.println(userId + " not found or has no friends");
                            }
                        }
                );
    }
}
