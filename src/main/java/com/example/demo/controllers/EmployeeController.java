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

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Endpoint to find employees by department using JPQL
    @GetMapping("/bydepartment/jpql")
    public List<Employee> findEmployeesByDepartmentJPQL(@RequestParam String department) {
        return employeeRepository.findEmployeesByDepartmentJPQL(department);
    }
    
    
    @GetMapping("/bydepartment/jpqlsingle")
    public String findEmployeeByDepartmentJPQL(@RequestParam String department) {
        String employee= employeeRepository.findEmployeenameByDepartmentJPQL(department);
        return "we got the employee "+employee;
    }


    // Endpoint to find employees by department using native SQL
    @GetMapping("/bydepartment/nativesql")
    public List<Employee> findEmployeesByDepartmentNativeSQL(@RequestParam String department) {
        return employeeRepository.findEmployeesByDepartmentNativeSQL(department);
    }
	
    // Endpoint to find employees by name and department using indexed parameters
    @GetMapping("/bynameanddepartment")
    public List<Employee> findEmployeesByNameAndDepartment(@RequestParam String name, @RequestParam String department) {
        return employeeRepository.findEmployeesByNameAndDepartment(name, department);
    }
}

