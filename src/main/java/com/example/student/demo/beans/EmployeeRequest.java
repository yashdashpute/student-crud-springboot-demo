package com.example.student.demo.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeRequest {
    private String id;
    private String name;
    private String address;
    private String contactNo;

}
