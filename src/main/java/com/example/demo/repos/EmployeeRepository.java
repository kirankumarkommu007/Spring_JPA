package com.example.demo.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.enitities.Employee;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find all employees with pagination
    Page<Employee> findAll(Pageable pageable);

    // Find all employees with sorting
    List<Employee> findAll(Sort sort);

    // Find employees by department with pagination and sorting
    @Query("SELECT e FROM Employee e WHERE e.department = :dept")
    Page<Employee> findByDepartment(@Param("dept") String department, Pageable pageable);

    // Find employee names by department with pagination and sorting
    @Query("SELECT e.name FROM Employee e WHERE e.department = :dept")
    Page<String> findEmployeeNamesByDepartment(@Param("dept") String department, Pageable pageable);
}
