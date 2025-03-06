package com.example.webfluxdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MongoService {
    @Autowired
    PersonRepository personRepository;
//    private List<Person> persons;

    @PostConstruct
    public void init() {
        System.out.println("initializing HelloService");
        List<Person> persons;
        Person person1 = new Person("1","person1",25,25000);
        Person person2 = new Person("2","person2",25,25000);
        Person person3 = new Person("3","person3",25,25000);

        persons = Arrays.asList(person1, person2, person3);
        personRepository.saveAll(persons);
    }
    public List<Person> getPersons() {
//        return persons;
        return personRepository.findAll();
    }
    public Person createPerson(Person person) {
//        List<Person> newPersons = new ArrayList<>(this.persons);
//        newPersons.add(person);
//        this.persons = newPersons;
          Person saved = personRepository.save(person);
        return saved;
    }
    public void deletePerson(String id) {
//        System.out.println("before deleting person " + persons);
//        List<Person> newPersons = persons.stream()
//                .filter(e -> !(e.getId().equals(id)))
//                .toList();
//        this.persons = newPersons;
//        System.out.println("after deleting person " + persons);
        personRepository.deleteById(id);
    }

    public Person getPerson(String id) {
//        Person result = null;
//        for (Person person : persons) {
//            if (person.getId().equals(id)) {
//                result = person;
//            }
//        }
        Person person = personRepository.findById(id).orElse(null);
        return person;
    }

}
