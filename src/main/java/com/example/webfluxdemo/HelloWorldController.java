package com.example.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class HelloWorldController {
    @Autowired
    HelloService helloService;
    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello, World!");    //prints Hello, World!
    }

    @GetMapping("/persons")
    public Flux<Person> getPersons() {
        List<Person> persons = helloService.getPersons();
        Flux<Person> just = Flux.just(persons.toArray(new Person[persons.size()]));
        return just;
    }

    @GetMapping("/persons/{id}")
    public Mono<Person> getPerson(@PathVariable String id) {
        return Mono.just(helloService.getPerson(id));
    }

    @PostMapping("/persons")
    public Mono<Person> postPerson(@RequestBody Person person) {
        return Mono.just(helloService.createPerson(person));
    }

    @DeleteMapping("/persons/{id}")
    public Mono<Void> deletePerson(@PathVariable String id) {
        helloService.deletePerson(id);
        return Mono.empty();
    }


}
