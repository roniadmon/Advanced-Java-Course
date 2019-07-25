package advanced.course.p1.unexpected;

import java.util.List;
import java.util.stream.Stream;

public class F5FixingWithException {
    private class UserNotFoundException extends RuntimeException {
    }

    private class UserHasNoFriendsException extends RuntimeException {
    }

    public Integer numberOfFriends(String userId) {
        MockDB.User userById = MockDB.getUserById(userId);
        if (userById == null) {
            throw new UserNotFoundException();
        }
        List<MockDB.User> friends = userById.getFriends();
        if (friends == null) {
            throw new UserHasNoFriendsException();
        }
        return friends.size();
    }

    public static void main(String[] args) {
        Stream
                .of("Marco", "Polo", "Other")
                .forEach(
                        userId -> {
                            try {
                                Integer numberOfFriends = new F5FixingWithException().numberOfFriends(userId);
                                System.out.println(userId + " has " + numberOfFriends + " friends!");
                            } catch (UserNotFoundException e) {
                                System.out.println(userId + " was not found");
                            } catch (UserHasNoFriendsException e) {
                                System.out.println(userId + " has no friends :(");
                            }
                        }
                );
    }
}
