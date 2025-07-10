package br.unesp.rc.MSEmployee.controller;

import br.unesp.rc.MSEmployee.dto.LoginRequest;
import br.unesp.rc.MSEmployee.entity.Employee;
import br.unesp.rc.MSEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Endpoint to create a new employee.
     * This operation should be restricted to authorized personnel (e.g., ADMIN).
     * @param employee A JSON object representing the employee.
     * @return The created employee with an HTTP 201 status.
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.create(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    /**
     * Endpoint to authenticate an employee.
     * @param loginRequest DTO containing user and password.
     * @return ResponseEntity indicating success or failure.
     */
    @PostMapping("/auth")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = employeeService.authenticate(loginRequest.getUser(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Employee authenticated successfully.");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials.");
        }
    }
}
