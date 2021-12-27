package com.happiestlearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.happiestlearning.bean.PatientBean;
import com.happiestlearning.entity.Employee;
import com.happiestlearning.entity.Patient;
import com.happiestlearning.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Employee> getAll() {

        List<Employee> empsFromDb = new ArrayList<>();
        empsFromDb = employeeRepository.findAll();

        List<Employee> emps = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setId(100);
        emp1.setName("Rajesh");
        Employee emp2 = new Employee();
        emp2.setId(200);
        emp2.setName("Raghu");
        emps.add(emp1);
        emps.add(emp2);
        return empsFromDb;
    }

    @Override
    public void addEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    @Override
    public Long getEmployeeCount() {
        return employeeRepository.count();
    }

    @Override
    public void deleteEmployee(Employee emp) {
        employeeRepository.delete(emp);

    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    @Override
    public void addBulkEmployees(int counter) {

        List<Employee> emps = new ArrayList<>();

        for (int i = 0; i < counter; i++) {
            // emp1.setId(100);
            Employee emp1 = new Employee();
            emp1.setAddress("Temp" + "-" + i);
            emp1.setName("Rajesh" + "###" + i);
            emp1.setEmail("testmail@gmail.com");
            emp1.setMobile("111111111111");
            emp1.setQualification("BA");
            emps.add(emp1);
        }

        employeeRepository.saveAll(emps);
    }

    @Override
    public String getPatientInfo() {
        String fooResourceUrl = "http://localhost:8090/patient/get-patient";
        Patient patient = restTemplate.getForObject(fooResourceUrl, Patient.class);

        return patient.getName();
    }

    @Override
    public String addPatientInfo() {
        String fooResourceUrl = "http://localhost:8090/patient/add-patient";

        HttpEntity<PatientBean> patientBean = new HttpEntity<>(new PatientBean("rest template", "id"));
        restTemplate.postForObject(fooResourceUrl, patientBean, PatientBean.class);
        // Patient patient = restTemplate.getForObject(fooResourceUrl, Patient.class);

        return "success";

    }

}
