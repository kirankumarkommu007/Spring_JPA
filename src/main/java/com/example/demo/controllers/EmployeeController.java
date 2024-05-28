package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.enitities.Address;
import com.example.demo.enitities.Employee;
import com.example.demo.repos.AddressRepository;
import com.example.demo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
         employeeService.saveEmployee(employee);
         return "employee saved Successfully";
    }
    
    
    @PostMapping("/add")
    public String addAdress(@RequestBody Address address) {
         addressRepository.save(address);
         return "address saved Successfully";
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
