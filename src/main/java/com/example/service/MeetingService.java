package com.example.service;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.entity.Meeting;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public Collection<Meeting> getAll(){
        Collection<Meeting> result = new ArrayList<>();
        Meeting meeting = new Meeting(LocalDateTime.now(),"name topic");
        Employee employee = new Employee("sergey pryanichnikov",LocalDate.now());
        Employee employee2 = new Employee("sergey jjjjjjjj",LocalDate.now());
        Employee employee3 = new Employee("sergey 3333333333333",LocalDate.now());

        Department department = new Department("department");



        employee.setDepartment(department);
        meeting.setResponsible(employee);

        meeting.getListOfParticipants().add(employee);
        meeting.getListOfParticipants().add(employee2);
        meeting.getListOfParticipants().add(employee3);
        result.add(meeting);
        result.add(meeting);
        result.add(meeting);
        result.add(meeting);
        result.add(meeting);

        departmentRepository.save(department);
        employeeRepository.save(employee);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);


        meetingRepository.save(result);
        return result;
    }

    public Meeting getBiId(Long id){
        return meetingRepository.findOne(1l);
    }
}
