package com.happiestlearning.service;

import java.util.List;

import com.happiestlearning.entity.Employee;

//import com.happiestlearning.bean.Employee;

public interface EmployeeService {

    public List<Employee> getAll();

    public void addEmployee(Employee emp);

    public Long getEmployeeCount();

    public void deleteEmployee(Employee emp);

    public void updateEmployee(Employee emp);

    public void addBulkEmployees(int counter);

    public String getPatientInfo();

    public String addPatientInfo();
}
