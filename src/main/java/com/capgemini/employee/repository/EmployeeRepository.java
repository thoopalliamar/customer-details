package com.capgemini.employee.repository;

import org.springframework.data.repository.CrudRepository;
import com.capgemini.employee.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	public Employee findByAccountID(Long accountId);

}
