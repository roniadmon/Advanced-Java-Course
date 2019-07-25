package advanced.course.p1.unexpected;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class MockDB {
    private static Map<String, User> db = new HashMap<>();

    static {
        User marco = new User();
        marco.friends = new LinkedList<>();
        marco.friends.add(new User());
        marco.friends.add(new User());
        marco.friends.add(new User());
        db.put("Marco", marco);

        User polo = new User();
        db.put("Polo", polo);
    }

    static User getUserById(String userId) {
        return db.get(userId);
    }

    public static class User {
        private List<User> friends;

        List<User> getFriends() {
            return friends;
        }
    }
}
