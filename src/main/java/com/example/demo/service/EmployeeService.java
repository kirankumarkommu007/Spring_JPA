package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enitities.Employee;
import com.example.demo.repos.AddressRepository;
import com.example.demo.repos.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Employee saveEmployee(Employee employee) {
        addressRepository.save(employee.getAddress());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
