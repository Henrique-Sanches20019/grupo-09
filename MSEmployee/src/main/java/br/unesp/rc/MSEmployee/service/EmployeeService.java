package br.unesp.rc.MSEmployee.service;

import br.unesp.rc.MSEmployee.entity.Employee;
import br.unesp.rc.MSEmployee.repository.AccessRepository;
import br.unesp.rc.MSEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AccessRepository accessRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, AccessRepository accessRepository) {
        this.employeeRepository = employeeRepository;
        this.accessRepository = accessRepository;
    }

    /**
     * Saves a new employee to the database.
     * @param employee The employee object to be created.
     * @return The saved employee entity.
     */
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Authenticates an employee based on username and password.
     * @param username The employee's username.
     * @param password The employee's password.
     * @return true if credentials are valid, false otherwise.
     */
    public boolean authenticate(String username, String password) {
        return accessRepository.findByUser(username)
                .map(access -> access.getPassword().equals(password))
                .orElse(false);
    }
}
