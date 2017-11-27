package com.example.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Meeting {

    @Id
    private Long id;
    private LocalDateTime dateTime;
    private String topic;
    @OneToOne
    private Employee responsible;
    @OneToMany
    private Collection<Employee> listOfParticipants;

    public Meeting() {
    }

    public Meeting(LocalDateTime dateTime, String topic, Employee responsible) {
        this.dateTime = dateTime;
        this.topic = topic;
        this.responsible = responsible;
    }
}
