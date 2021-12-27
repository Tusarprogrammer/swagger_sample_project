package com.happiestlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happiestlearning.entity.Employee;
//import com.happiestlearning.bean.Employee;
import com.happiestlearning.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @GetMapping("/getall")
    public List<Employee> getAll() {

        return employeeServiceImpl.getAll();
    }

    @GetMapping("/getCount")
    public Long getCount() {

        return employeeServiceImpl.getEmployeeCount();
    }

    @GetMapping("/get-patient")
    public String getPatient() {

        return employeeServiceImpl.getPatientInfo();
    }

    @GetMapping("/add-employees/{counter}")
    public String addBulkEmployees(@PathVariable int counter) {
        System.out.println("==============id start===============");
        System.out.println(counter);
        System.out.println("==============id end===============");
        employeeServiceImpl.addBulkEmployees(counter);
        return "Employee Added";
    }

    @GetMapping("/add-patient")
    public String addPatient() {

        return employeeServiceImpl.addPatientInfo();
    }
}