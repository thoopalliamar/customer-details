package com.capgemini.employee.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.employee.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	//@Query("SELECT t.accountId FROM employee WHERE t.accountId = :accountId AND NOT NULL")
	@Query("SELECT p FROM employee p WHERE p.accountId = :accountid AND NOT NULL'")
	public Employee findByAccountID(@Param("accountId")Long accountId);
	
	

}
