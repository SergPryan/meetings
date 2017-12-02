package com.example.service;

import com.example.entity.Department;
import com.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentService {


    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Collection<Department> getAll(){
        return departmentRepository.findAll();
    }

    public Department findById(Long id){
        return departmentRepository.findOne(id);
    }

}
