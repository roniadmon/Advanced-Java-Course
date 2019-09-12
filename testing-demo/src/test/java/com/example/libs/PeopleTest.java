package com.example.libs;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PeopleTest {

    @Test
    void test() {
        People people = new People();

        assertThat(people.getContacts()).contains(
                People.BATMAN
        );

        assertThat(people.getContacts()).containsExactlyInAnyOrder(
                People.ALFRED,
                People.BATMAN
        );

        assertThat(people.getContacts())
                .extracting(People.Person::getName)
                .contains("Bruce");

        assertThat(people.getContacts())
                .extracting(
                        People.Person::getName,
                        People.Person::getJob
                )
                .contains(
                        Tuple.tuple("Alfred", "Babysitter")
                );
    }
}
