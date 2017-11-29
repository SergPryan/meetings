package com.example.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Meeting {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime dateTime;
    private String topic;
    @OneToOne
    private Employee responsible;
    @OneToMany
    private Collection<Employee> listOfParticipants = new HashSet<>();

    public Meeting() {
    }

    public Meeting(LocalDateTime dateTime, String topic) {
        this.dateTime = dateTime;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Employee getResponsible() {
        return responsible;
    }

    public void setResponsible(Employee responsible) {
        this.responsible = responsible;
    }

    public Collection<Employee> getListOfParticipants() {
        return listOfParticipants;
    }

    public void setListOfParticipants(Collection<Employee> listOfParticipants) {
        this.listOfParticipants = listOfParticipants;
    }
}
