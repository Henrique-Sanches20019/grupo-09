package br.unesp.rc.MSEmployee.repository;

import br.unesp.rc.MSEmployee.entity.Access;
import br.unesp.rc.MSEmployee.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * Finds an Access entity by its user field.
     * @param user The username.
     * @return An Optional containing the Access entity if found.
     */
    Optional<Access> findByUser(String user);
}
