package com.example.student.demo.service.impl;

import com.example.student.demo.beans.EmployeeRequest;
import com.example.student.demo.beans.EmployeeResponse;
import com.example.student.demo.entity.StudentEntity;
import com.example.student.demo.repository.StudentRepository;
import com.example.student.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public String addEmployee(EmployeeRequest employeeRequest) {
        log.info("Post call");
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(employeeRequest, studentEntity);
        studentEntity = studentRepository.save(studentEntity);
        return studentEntity.getId();
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest) {
        log.info("update call");
        EmployeeResponse response = new EmployeeResponse();
        Optional<StudentEntity> employeeEntityOptional = studentRepository.findById(employeeRequest.getId());
        if(employeeEntityOptional.isPresent()) {
            StudentEntity studentEntity = employeeEntityOptional.get();
            BeanUtils.copyProperties(employeeRequest, studentEntity);
            studentEntity = studentRepository.save(studentEntity);
            BeanUtils.copyProperties(studentEntity, response);
        }
        return response;
    }


    @Override
    public EmployeeResponse getEmployee(String id) {
        log.info("Get call");
        EmployeeResponse response = new EmployeeResponse();
        Optional<StudentEntity> employeeEntityOptional = studentRepository.findById(id);
        if(employeeEntityOptional.isPresent()) {
            StudentEntity studentEntity = employeeEntityOptional.get();
            BeanUtils.copyProperties(studentEntity, response);
        }
        return response;
    }
}
