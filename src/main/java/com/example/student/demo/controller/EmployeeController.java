package com.example.student.demo.controller;

import com.example.student.demo.beans.EmployeeRequest;
import com.example.student.demo.beans.EmployeeResponse;
import com.example.student.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeService.addEmployee(employeeRequest));
    }


    @PutMapping("/update")
    public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeService.updateEmployee(employeeRequest));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable String id){
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }


}
