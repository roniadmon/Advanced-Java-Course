package advanced.course.p1.unexpected;

import java.util.stream.Stream;

public class F2Problems {
    public Integer numberOfFriends(String userId) {
        return MockDB.getUserById(userId).getFriends().size();
    }

    public static void main(String[] args) {
        Stream
                .of("Marco", "Polo", "Other")
                .forEach(
                        userId -> {
                            Integer numberOfFriends = new F2Problems().numberOfFriends(userId);
                            System.out.println(userId + " has " + numberOfFriends + " friends!");
                        }
                );
    }
}
