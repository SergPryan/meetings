package com.example.controllers;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<EmployeeDto>> getAll(@RequestParam(required = false,name = "departmentId") Long departmentId){
        Collection<EmployeeDto> result;
        if(departmentId != null)
        {
            result = employeeService.getAll(departmentId).stream().map(this::convertToDto).collect(Collectors.toList());
        } else {
            result = employeeService.getAll().stream().map(this::convertToDto).collect(Collectors.toList());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    EmployeeDto convertToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFullName(employee.getFullName());
        employeeDto.setAge(LocalDate.now().getYear() - employee.getBirthday().getYear());
        if(employee.getDepartment() != null)
        {
            employeeDto.setDepartment(employee.getDepartment());
        }
        return employeeDto;
    }

}
