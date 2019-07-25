package advanced.course.p1.unexpected;

import java.util.List;
import java.util.stream.Stream;

public class F3FixingWithNull {
    public Integer numberOfFriends(String userId) {
        MockDB.User userById = MockDB.getUserById(userId);
        if (userById == null) {
            return null;
        }
        List<MockDB.User> friends = userById.getFriends();
        if (friends == null) {
            return null;
        }
        return friends.size();
    }

    public static void main(String[] args) {
        Stream
                .of("Marco", "Polo", "Other")
                .forEach(
                        userId -> {
                            Integer numberOfFriends = new F3FixingWithNull().numberOfFriends(userId);
                            if (numberOfFriends != null) {
                                System.out.println(userId + " has " + numberOfFriends + " friends!");
                            } else {
                                System.out.println(userId + " not found or has no friends");
                            }
                        }
                );
    }
}
