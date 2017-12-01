package com.example.controllers;

import com.example.dto.MeetingDto;
import com.example.entity.Employee;
import com.example.entity.Meeting;
import com.example.repository.MeetingRepository;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import com.example.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private MeetingRepository meetingRepository;

    @GetMapping
    public String get(){
        return "meeting.html";
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<MeetingDto>> getAll(@RequestParam(required = false,name = "topic") String topic,
                                                         @RequestParam(required = false,name = "dateFrom") String dateFrom,
                                                         @RequestParam(required = false,name = "dateTo") String dateTo,
                                                         @RequestParam(required = false,name = "departmentId") String departmentId,
                                                         @RequestParam(required = false,name = "employeeId") String employeeId){
        Collection<Meeting> tmp;
        if(topic != null || dateFrom != null || dateTo != null | departmentId != null | employeeId != null){
            tmp = meetingRepository.filterMeeting(topic,dateFrom,dateTo,departmentId,employeeId);
            return new ResponseEntity<>(tmp.stream().map(this::convertToDto).collect(Collectors.toList()), HttpStatus.OK);
        }

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

//    @GetMapping("/edit/{id}")
//    public String getTemplate(Model model,@PathParam("id") Long id){
//        Meeting meeting = meetingService.getBiId(id);
//        model.addAttribute("currentYear", LocalDate.now().getYear());
//        model.addAttribute("meeting",meeting);
//        model.addAttribute("listDepartment",departmentService.getAll());
//        model.addAttribute("listEmployee",employeeService.getAll());
//        model.addAttribute("listOfParticipants",meeting.getListOfParticipants());
//        return "meeting";
//
//    }

    @PostMapping("/save")
    public String saveMeeting( Meeting meeting){
        System.out.println(meeting.getTopic());
        return "index";
    }

    @GetMapping("/template")
    public String getTemplate(){
        return "meeting";
    }
}
