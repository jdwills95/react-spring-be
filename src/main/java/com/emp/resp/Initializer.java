package com.emp.resp;


import com.emp.resp.model.Employee;
import com.emp.resp.model.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
abstract
class Initializer implements CommandLineRunner {

    /*private final EmployeeRepository repository;

    public Initializer(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Denver JUG", "Utah JUG", "Seattle JUG",
                "Richmond JUG").forEach(fName ->
                repository.save(new Employee(fName))
        );

        repository.findAll().forEach(System.out::println);
    }*/
}
