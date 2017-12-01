package com.example.controllers;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.entity.Meeting;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class MainController {


//    @Autowired
//    MeetingRepository meetingRepository;
//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Autowired
//    DepartmentRepository departmentRepository;
//
//    @GetMapping("/test")
//    public void get(){
//        Meeting meeting = new Meeting(LocalDateTime.now(),"topic meeting");
//        Employee employee1 = new Employee("serge p", LocalDate.now());
//        Employee employee2 = new Employee("mihail p", LocalDate.now());
//        Employee employee3 = new Employee("petr p", LocalDate.now());
//        Department department1 = new Department("depart 1");
//        Department department2 = new Department("depart 2");
//        departmentRepository.save(department1);
//        departmentRepository.save(department2);
//        meetingRepository.save(meeting);
//        employeeRepository.save(employee1);
//        employeeRepository.save(employee2);
//        employeeRepository.save(employee3);
//        meeting.setResponsible(employee1);
//        meeting.getListOfParticipants().add(employee2);
//        meeting.getListOfParticipants().add(employee3);
//        meeting.setDepartment(department1);
//        meetingRepository.save(meeting);
//
//    }

}
