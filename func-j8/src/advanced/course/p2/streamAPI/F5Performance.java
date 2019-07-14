package advanced.course.p2.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class F5Performance {

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

        findFirstFirstNameThatStartsWithDa1(people);
        findFirstFirstNameThatStartsWithDa2(people);
    }

    private static String findFirstFirstNameThatStartsWithDa1(List<Person> people) {
        Stream<String> firstNameStream = people.stream().map(person -> person.firstName);
        Stream<String> filteredStream = firstNameStream.filter(firstName -> firstName.startsWith("Da"));
        return filteredStream.findFirst().get();
    }

    private static String findFirstFirstNameThatStartsWithDa2(List<Person> people) {
        for (Person person : people) {
            if (person.firstName.startsWith("Da")) {
                return person.firstName;
            }
        }
        throw new NullPointerException();
    }
}
