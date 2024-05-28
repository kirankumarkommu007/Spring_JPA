package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.enitities.Employee;
import com.example.demo.repos.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.example.demo.enitities.Employee;
import com.example.demo.repos.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	// Endpoint to find all employees with pagination
	@GetMapping("/page")
	public Page<Employee> getAllEmployeesWithPagination() {
		int page = 0;
		int size = 2;
		Pageable pageable = PageRequest.of(page, size);
		return employeeRepository.findAll(pageable);
	}

	// Endpoint to find all employees with sorting
	@GetMapping("/sort")
	public List<Employee> getAllEmployeesWithSorting(
		) {
		 String sortBy="name"; 
		 String direction="asc";
		Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		return employeeRepository.findAll(sort);
	}

	// Endpoint to find employees by department with pagination and sorting
    @GetMapping("/bydepartment")
    public Page<Employee> getEmployeesByDepartment(@RequestParam String department, 
			@RequestParam int page,
			@RequestParam int size,
			@RequestParam String sortBy, 
			@RequestParam String direction) {
        
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findByDepartment(department, pageable);
    }

    
    
}
