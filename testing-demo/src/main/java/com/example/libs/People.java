package com.example.libs;

import java.util.List;
import java.util.Objects;

public class People {

    public static final Person BATMAN = new Person().setName("Bruce").setJob("Batman");
    public static final Person ALFRED = new Person().setName("Alfred").setJob("Babysitter");

    private List<Person> contacts = List.of(BATMAN, ALFRED);

    public List<Person> getContacts() {
        return contacts;
    }

    public static class Person {
        private String name;
        private String job;

        public String getName() {
            return name;
        }

        Person setName(String name) {
            this.name = name;
            return this;
        }

        public String getJob() {
            return job;
        }

        Person setJob(String job) {
            this.job = job;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(job, person.job);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, job);
        }
    }
}
