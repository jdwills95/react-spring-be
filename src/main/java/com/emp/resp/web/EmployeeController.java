package com.emp.resp.web;

import com.emp.resp.model.Employee;
import com.emp.resp.model.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
class EmployeeController {

    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    Collection<Employee> employees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    ResponseEntity<?> getEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/employee")
    ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) throws URISyntaxException {
        log.info("Request to create employee: {}", employee);
        Employee result = employeeRepository.save(employee);
        return ResponseEntity.created(new URI("/api/employee/" + result.getId()))
                .body(result);
    }

    @PutMapping("/employee/{id}")
    ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {
        log.info("Request to update employee: {}", employee);
        Employee result = employeeRepository.save(employee);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        log.info("Request to delete employee: {}", id);
        employeeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
