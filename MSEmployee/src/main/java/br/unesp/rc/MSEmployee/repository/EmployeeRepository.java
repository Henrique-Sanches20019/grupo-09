package br.unesp.rc.MSEmployee.repository;

import br.unesp.rc.MSEmployee.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
