package com.example.controllers;

import com.example.dto.EditMeetingDto;
import com.example.dto.EmployeeDto;
import com.example.dto.MeetingDto;
import com.example.entity.Employee;
import com.example.entity.Meeting;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import com.example.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/meeting")
public class MeetingController {

    private final MeetingService meetingService;

    private final EmployeeController employeeController;

    private final DepartmentService departmentService;

    private final EmployeeService employeeService;

    @Autowired
    public MeetingController(MeetingService meetingService, EmployeeController employeeController, DepartmentService departmentService, EmployeeService employeeService) {
        this.meetingService = meetingService;
        this.employeeController = employeeController;
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/:{id}")
    public ResponseEntity<EditMeetingDto> getById(@PathVariable Long id){
        EditMeetingDto result = convertToDtoEditMeting(meetingService.getById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<MeetingDto>> getAll(@RequestParam(required = false,name = "topic") String topic,
                                                         @RequestParam(required = false,name = "dateFrom") String dateFrom,
                                                         @RequestParam(required = false,name = "dateTo") String dateTo,
                                                         @RequestParam(required = false,name = "departmentId") String departmentId,
                                                         @RequestParam(required = false,name = "employeeId") String employeeId){
        Collection<MeetingDto> result;
        if(topic != null || dateFrom != null || dateTo != null | departmentId != null | employeeId != null){
            result = meetingService.filterMeeting(topic,dateFrom,dateTo,departmentId,employeeId).stream().map(this::convertToDto).collect(Collectors.toList());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        result = meetingService.getAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private MeetingDto convertToDto(Meeting meeting){
        MeetingDto meetingDto = new MeetingDto();
        meetingDto.setId(meeting.getId());
        meetingDto.setDate(meeting.getDateTime().format(DateTimeFormatter.ISO_DATE));
        meetingDto.setDepartment(meeting.getDepartment());
        meetingDto.setTopic(meeting.getTopic());
        if(meeting.getResponsible() != null){
            EmployeeDto employeeDto = employeeController.convertToDto(meeting.getResponsible());
            meetingDto.setResponsible(employeeDto);
        }
        if(meeting.getListOfParticipants() != null)
        {
            meetingDto.setNumberOfParticipants(meeting.getListOfParticipants().size());
        }
        return meetingDto;
    }

    private EditMeetingDto convertToDtoEditMeting(Meeting meeting){
        EditMeetingDto meetingDto = new EditMeetingDto();
        meetingDto.setId(meeting.getId());
        meetingDto.setDate(meeting.getDateTime().format(DateTimeFormatter.ISO_DATE));
        meetingDto.setDepartment(meeting.getDepartment());
        meetingDto.setTopic(meeting.getTopic());
        if(meeting.getResponsible() != null){
            EmployeeDto employeeDto = employeeController.convertToDto(meeting.getResponsible());
            meetingDto.setResponsible(employeeDto);
        }
        if(meeting.getListOfParticipants() != null){
            List<EmployeeDto> employeeDtoList = meeting.getListOfParticipants().stream().map(employeeController::convertToDto).collect(Collectors.toList());
            meetingDto.setListOfParticipants(employeeDtoList);
        }
        return meetingDto;
    }

    private Meeting convertEditMetingToMeeting(EditMeetingDto dto){
        Meeting meeting = meetingService.getById(dto.getId());
        meeting.setDepartment(departmentService.findById(dto.getDepartment().getId()));
        meeting.setTopic(dto.getTopic());
        Employee responsible = employeeService.findById(dto.getResponsible().getId());
        meeting.setResponsible(responsible);
        return meeting;
    }

    @PostMapping("/save")
    public ResponseEntity saveMeeting(@RequestBody EditMeetingDto dto){
        Meeting meeting = this.convertEditMetingToMeeting(dto);
        System.out.println(meeting.getTopic());
        System.out.println(dto.getDate());
        meetingService.save(meeting);
        return new ResponseEntity(HttpStatus.OK);
    }

}
