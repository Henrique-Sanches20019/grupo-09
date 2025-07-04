package br.unesp.rc.MSEmployee.service;

import br.unesp.rc.MSEmployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Authenticates an employee based on username and password.
     * @param username The employee's username.
     * @param password The employee's password.
     * @return true if credentials are valid, false otherwise.
     */
    public boolean authenticate(String username, String password) {
        return employeeRepository.findByUser(username)
                .map(access -> access.getPassword().equals(password))
                .orElse(false);
    }
}
