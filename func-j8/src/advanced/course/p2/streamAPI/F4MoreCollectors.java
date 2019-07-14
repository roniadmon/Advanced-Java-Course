package advanced.course.p2.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class F4MoreCollectors {

    public static class Person {
        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String firstName;
        public String lastName;

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Moshe", "Cohen"),
                new Person("Daniel", "Jacobson"),
                new Person("David", "Cohen"),
                new Person("Daniel", "Taub")
        );

        Optional<String> reduce = people.stream()
                .map(Person::toString)
                .reduce((p1, p2) -> p1 + ", " + p2);
        System.out.println(reduce);

        String joining = people.stream()
                .map(Person::toString)
                .collect(Collectors.joining(", "));
        System.out.println(joining);

        Map<String, List<Person>> groupings = people.stream()
                .collect(Collectors.groupingBy(person -> person.firstName));
        System.out.println(groupings);
    }
}
