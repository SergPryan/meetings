package com.example.dto;

import com.example.entity.Department;

public class MeetingDto {
    private Long id;
    private String date;
    private String topic;
    private Department department;
    private EmployeeDto responsible;
    private int numberOfParticipants;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public EmployeeDto getResponsible() {
        return responsible;
    }

    public void setResponsible(EmployeeDto responsible) {
        this.responsible = responsible;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
