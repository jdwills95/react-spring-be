package com.emp.resp;

import com.emp.resp.model.Event;
import com.emp.resp.model.Employee;
import com.emp.resp.model.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final EmployeeRepository repository;

    public Initializer(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Denver JUG", "Utah JUG", "Seattle JUG",
                "Richmond JUG").forEach(name ->
                repository.save(new Employee(name))
        );

        Employee djug = repository.findByName("Denver JUG");
        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);

        repository.findAll().forEach(System.out::println);
    }
}
