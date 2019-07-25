package advanced.course.p1.unexpected;

public class F1Working {
    public Integer numberOfFriends(String userId) {
        return MockDB.getUserById(userId).getFriends().size();
    }

    public static void main(String[] args) {
        Integer numberOfFriends = new F1Working().numberOfFriends("Marco");
        System.out.println("You have " + numberOfFriends + " friends!");
    }
}
