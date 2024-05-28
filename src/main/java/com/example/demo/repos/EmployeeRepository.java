package com.example.demo.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.enitities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	// Find employees by name
	List<Employee> findByName(String name);

	// Find employees by department
	List<Employee> findByDepartment(String department);
	
	// Count employees by department
	long countByDepartment(String department);
	
	// Delete employees by name
	void deleteByName(String name);

	// Delete employees by department
	void deleteByDepartment(String department);


}
