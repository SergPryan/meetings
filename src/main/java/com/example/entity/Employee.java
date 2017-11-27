package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    private Long id;
    private String fullName;
    private LocalDate birthday;

    public Employee() {

    }

    public Employee(String fio, LocalDate birthday) {
        this.fullName = fio;
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
}
