package com.example.service;

import com.example.entity.Meeting;
import com.example.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;

    @Autowired
    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public Collection<Meeting> getAll(){

        return meetingRepository.findAll();
    }

    public Meeting save(Meeting meeting){
        meetingRepository.save(meeting);
        return meeting;
    }

    public Meeting getById(Long id){
        return meetingRepository.findOne(id);
    }

    public Collection<Meeting> filterMeeting(String topic, String dateFrom, String dateTo, String departmentId, String responsibleId){
        return meetingRepository.filterMeeting(topic,dateFrom,dateTo,departmentId,responsibleId);
    }
}
