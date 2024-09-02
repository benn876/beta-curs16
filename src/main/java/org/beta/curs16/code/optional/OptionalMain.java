package org.beta.curs16.code.optional;

import org.beta.curs16.code.model.Person;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        PersonService service = new PersonService();

//        Person person = service.findPersonByNameWithoutOptional("Ionel");
//        System.out.println(person.name());

        String string1 = "bla bla";
        String string2 = null;
        Optional<String> optional1 = Optional.ofNullable(string1);
        Optional<String> optional2 = Optional.ofNullable(string2);

        if(optional1.isPresent()){
            System.out.println(optional1.get());
        }
        if(optional2.isPresent()){
            System.out.println(optional2.get());
        }

        Optional<Person> optionalPerson = service.findPersonByNameWithOptional("Mihai");

        if(optionalPerson.isPresent()){
            Person person = optionalPerson.get();
            System.out.println(person.name());
        } else {
            System.out.println("No person found");
        }

        Person anotherPerson = optionalPerson.orElse(Person.builder()
                .name("Default Person")
                .job("Default Job")
                .age(1)
                .build());
        System.out.println(anotherPerson.name());

        String justTheName = optionalPerson
                .map(person -> {
                    System.out.println(person);
                    return person.name();
                })
                .orElse("No name");
        System.out.println(justTheName);
    }
}
