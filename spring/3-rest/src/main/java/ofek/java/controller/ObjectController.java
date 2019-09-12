package ofek.java.controller;

import ofek.java.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ObjectController {
    private List<Employee> employees = Arrays.asList(
            new Employee(1, "A"),
            new Employee(2, "B")
    );

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> allEmployees() {
        return ResponseEntity.ok(employees);
    }
}
