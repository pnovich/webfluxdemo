package com.example.webfluxdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HelloService {
    private List<Person> persons;

    @PostConstruct
    public void init() {
    System.out.println("initializing HelloService");
    Person person1 = new Person("1","person1",25,25000);
    Person person2 = new Person("2","person2",25,25000);
    Person person3 = new Person("3","person3",25,25000);

    persons = Arrays.asList(person1, person2, person3);
}
public List<Person> getPersons() {
    return persons;
}
public Person createPerson(Person person) {
        List<Person> newPersons = new ArrayList<>(this.persons);
        newPersons.add(person);
        this.persons = newPersons;
    return person;
}
public void deletePerson(String id) {
    System.out.println("before deleting person " + persons);
    List<Person> newPersons = persons.stream()
                    .filter(e -> !(e.getId().equals(id)))
                            .toList();
    this.persons = newPersons;
    System.out.println("after deleting person " + persons);
}

public Person getPerson(String id) {
        Person result = null;
        for (Person person : persons) {
            if (person.getId().equals(id)) {
                result = person;
            }
        }
        return result;
}
}
