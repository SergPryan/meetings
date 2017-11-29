package com.example.service;

import com.example.entity.Department;
import com.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    public Collection<Department> getAll(){
        return departmentRepository.findAll();
    }

}
