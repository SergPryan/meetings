package com.example.service;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.entity.Meeting;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class MeetingService {

    public Collection<Meeting> getAll(){
        Collection<Meeting> result = new ArrayList<>();
        Meeting meeting = new Meeting(LocalDateTime.now(),"name topic");
        Employee employee = new Employee("sergey pryanichnikov",LocalDate.now());

        Department department = new Department("department");
        employee.setDepartment(department);
        meeting.setResponsible(employee);
        result.add(meeting);
        result.add(meeting);
        result.add(meeting);
        result.add(meeting);
        result.add(meeting);
        return result;
    }
}
