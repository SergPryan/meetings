package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private LocalDate birthday;
    @OneToOne
    private Department department;

    public Employee() {
    }

    public Employee(String fullName, LocalDate birthday) {
        this.fullName = fullName;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
