package org.beta.curs16.code.streams;

import org.beta.curs16.code.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMain {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                Person.builder()
                        .name("Mihai")
                        .age(44)
                        .job("Driver")
                        .build(),
                Person.builder()
                        .name("George")
                        .age(32)
                        .job("Student")
                        .build(),
                Person.builder()
                        .name("Ioana")
                        .age(32)
                        .job("Teacher")
                        .build()
        );

        Stream<Person> stream = persons.stream();


        List<Person> result = persons.stream()
                .filter(person -> person.age() > 30)
                .filter(person -> person.name().startsWith("M"))
                .toList();
        System.out.println(result);

        List<String> namesLength = persons.stream()
                .map(Person::name)
                .toList();
        System.out.println(namesLength);

        List<Person> skipElements = persons.stream()
                .skip(2)
                .toList();
        System.out.println(skipElements);

        List<Person> limitPersons = persons.stream()
                .limit(2)
                .toList();
        System.out.println(limitPersons);

        List<Integer> integers = List.of(1,2,3,2,4,5,634,43,44,44);
        List<Integer> distinctIntegers = integers.stream()
                .distinct()
                .toList();
        System.out.println(distinctIntegers);

        Set<Integer> uniqueAge = persons.stream()
                .map(Person::age)
                .collect(Collectors.toSet());
        System.out.println(uniqueAge);

        long count = persons.stream()
                .filter(person -> person.age() > 35)
                .count();
        System.out.println(count);

        boolean allMajor = persons.stream()
                .allMatch(person -> person.age() > 18);
        System.out.println(allMajor);

        boolean atLeastOnePersonWithM = persons.stream()
                .anyMatch(person -> person.name().startsWith("Z"));
        System.out.println(atLeastOnePersonWithM);

        Optional<Person> optionalPerson = persons.stream()
                .filter(person -> person.age() > 30)
                .findFirst();

        optionalPerson.ifPresent(person-> System.out.println(person));
    }
}
