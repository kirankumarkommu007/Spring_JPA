package com.example.demo.controllers;

import com.example.demo.enitities.Address;
import com.example.demo.enitities.Employee;
import com.example.demo.repos.AddressRepository;
import com.example.demo.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeAddressController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    // Endpoint to add an Employee with an Address
    @PostMapping("/employees")
    public String addEmployeeWithAddress(@RequestBody Employee employee) {
        if (employee.getAddress() != null) {
            addressRepository.save(employee.getAddress());
        }
        employeeRepository.save(employee);
        return "Employee added successfully";
    }

    // Endpoint to add an Address with an Employee
    @PostMapping("/addresses")
    public String addAddressWithEmployee(@RequestBody Address address) {
        if (address.getEmployee() != null) {
            employeeRepository.save(address.getEmployee());
        }
        addressRepository.save(address);
        return "Address added successfully";
    }
}
