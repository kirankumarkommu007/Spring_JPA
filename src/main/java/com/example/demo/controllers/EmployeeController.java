package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.enitities.Employee;
import com.example.demo.repos.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/byname/{name}")
	public List<Employee> findEmployeesByName(@PathVariable String name) {
		return employeeRepository.findByName(name);
	}

	@GetMapping("/bydepartment/{department}")
	public List<Employee> findEmployeesByDepartment(@PathVariable String department) {
		return employeeRepository.findByDepartment(department);
	}

	@GetMapping("/countbydepartment")
	public long countEmployeesByDepartment(@RequestParam String department) {
		return employeeRepository.countByDepartment(department);
	}

	@DeleteMapping("/deletebyname/{name}")
	public void deleteEmployeesByName(@PathVariable String name) {
		employeeRepository.deleteByName(name);
	}

	@DeleteMapping("/deletebydepartment/{department}")
	public void deleteEmployeesByDepartment(@PathVariable String department) {
		employeeRepository.deleteByDepartment(department);
	}
}
