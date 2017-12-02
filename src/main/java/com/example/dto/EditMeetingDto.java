package com.example.dto;

import com.example.entity.Department;

import java.util.List;

public class EditMeetingDto {
    private Long id;
    private String date;
    private String topic;
    private Department department;
    private EmployeeDto responsible;
    private List<EmployeeDto> listOfParticipants;

    public List<EmployeeDto> getListOfParticipants() {
        return listOfParticipants;
    }

    public void setListOfParticipants(List<EmployeeDto> listOfParticipants) {
        this.listOfParticipants = listOfParticipants;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeDto getResponsible() {
        return responsible;
    }

    public void setResponsible(EmployeeDto responsible) {
        this.responsible = responsible;
    }
}
