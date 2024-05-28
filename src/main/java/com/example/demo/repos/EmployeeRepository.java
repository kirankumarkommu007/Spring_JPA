package com.example.demo.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.enitities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
