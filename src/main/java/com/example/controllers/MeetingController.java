package com.example.controllers;

import com.example.dto.MeetingDto;
import com.example.entity.Meeting;
import com.example.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping
    public String get(){
        return "meeting.html";
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<MeetingDto>> getAll(){
        Collection<MeetingDto> result = meetingService.getAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private MeetingDto convertToDto(Meeting meeting){
        MeetingDto meetingDto = new MeetingDto();
        meetingDto.setId(meeting.getId());
        meetingDto.setDate(meeting.getDateTime().format(DateTimeFormatter.ISO_DATE));
        meetingDto.setDepartment(meeting.getResponsible().getDepartment().getName());
        meetingDto.setTopic(meeting.getTopic());
        if(meeting.getResponsible() != null){
            meetingDto.setResponsible(meeting.getResponsible().getFullName());
        }
        if(meeting.getListOfParticipants() != null)
        {
            meetingDto.setNumberOfParticipants(meeting.getListOfParticipants().size());
        }
        return meetingDto;
    }
}
