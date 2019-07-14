package advanced.course.p2.streamAPI;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class F3FlatMap {

    public static class Person {
        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String firstName;
        public String lastName;
        public List<String> nicknames = new LinkedList<>();

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {

        Person p1 = new Person("Moshe", "Cohen");
        p1.nicknames.add("Mushon");
        p1.nicknames.add("Moshiko");

        Person p2 = new Person("David", "Cohen");
        p2.nicknames.add("Dedi");
        p2.nicknames.add("Davidy");

        List<Person> people = Arrays.asList(p1, p2);

        people.stream().map(person -> person.nicknames);
    }
}
