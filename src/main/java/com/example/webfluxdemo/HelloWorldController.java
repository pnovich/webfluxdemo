package com.example.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class HelloWorldController {
    @Autowired
//    HelloService helloService;
    MongoService helloService;
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";    //prints Hello, World!
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        List<Person> persons = helloService.getPersons();
//        Flux<Person> just = Flux.just(persons.toArray(new Person[persons.size()]));
        return persons;
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable String id) {
        return helloService.getPerson(id);
    }

    @PostMapping("/persons")
    public Person postPerson(@RequestBody Person person) {
        return helloService.createPerson(person);
    }

    @DeleteMapping("/persons/{id}")
    public void deletePerson(@PathVariable String id) {
        helloService.deletePerson(id);
//        return Mono.empty();
    }


}
