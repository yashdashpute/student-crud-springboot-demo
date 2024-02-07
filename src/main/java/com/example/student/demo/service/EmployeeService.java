package com.example.student.demo.service;

import com.example.student.demo.beans.EmployeeRequest;
import com.example.student.demo.beans.EmployeeResponse;


public interface EmployeeService {
    String addEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse updateEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse getEmployee(String id);
}
