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
    private EmployeeRepository groupRepository;

    public EmployeeController(EmployeeRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/groups")
    Collection<Employee> groups() {
        return groupRepository.findAll();
    }

    @GetMapping("/group/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
        Optional<Employee> group = groupRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/group")
    ResponseEntity<Employee> createGroup(@Valid @RequestBody Employee group) throws URISyntaxException {
        log.info("Request to create group: {}", group);
        Employee result = groupRepository.save(group);
        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
                .body(result);
    }

    @PutMapping("/group/{id}")
    ResponseEntity<Employee> updateGroup(@Valid @RequestBody Employee group) {
        log.info("Request to update group: {}", group);
        Employee result = groupRepository.save(group);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete group: {}", id);
        groupRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
