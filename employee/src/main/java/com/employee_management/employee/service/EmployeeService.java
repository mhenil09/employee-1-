package com.employee_management.employee.service;

import com.employee_management.employee.entity.Employee;
import com.employee_management.employee.exception.CustomException;
import com.employee_management.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired private EmployeeRepository employeeRepository;

    public Employee findByEmployeeCode(String employeeCode) {
        return employeeRepository.findEmployeeByEmployeeCode(employeeCode).orElseThrow(() -> new CustomException("Employee not found"));
    }
}
