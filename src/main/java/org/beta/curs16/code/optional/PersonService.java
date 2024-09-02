package org.beta.curs16.code.optional;

import org.beta.curs16.code.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonService {
    private List<Person> persons;

    public PersonService() {
        this.persons = Arrays.asList(
                Person.builder()
                        .name("Mihai")
                        .age(44)
                        .job("Driver")
                        .build(),
                Person.builder()
                        .name("George")
                        .age(22)
                        .job("Student")
                        .build(),
                Person.builder()
                        .name("Ioana")
                        .age(32)
                        .job("Teacher")
                        .build()
        );
    }

    public Optional<Person> findPersonByNameWithOptional(String name) {
        for (Person person : persons) {
            if (name.equalsIgnoreCase(person.name())) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }


    public Person findPersonByNameWithoutOptional(String name) {
        for (Person person : persons) {
            if (person.name().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }
}
