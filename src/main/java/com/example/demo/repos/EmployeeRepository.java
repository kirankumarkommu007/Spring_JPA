package com.example.demo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.enitities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Custom JPQL query to find employees by department
	@Query("SELECT e FROM Employee e WHERE e.department = :dept")
	List<Employee> findEmployeesByDepartmentJPQL(@Param("dept") String department);

	@Query("SELECT e.name FROM Employee e WHERE e.department = :dept")
	String findEmployeenameByDepartmentJPQL(@Param("dept") String department);

	// Custom native SQL query to find employees by department
	@Query(value = "SELECT * FROM  WHERE department = :dept", nativeQuery = true)
	List<Employee> findEmployeesByDepartmentNativeSQL(@Param("dept") String department);

	@Query("SELECT e FROM Employee e WHERE e.name = ?1 AND e.department = ?2")
	List<Employee> findEmployeesByNameAndDepartment(String name, String department);

}
