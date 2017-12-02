package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Collection<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Collection<Employee> getAll(Long departmentId){
        return employeeRepository.findAllByDepartment_Id(departmentId);
    }

    public Employee findById(Long id){
        return employeeRepository.findOne(id);
    }
}
