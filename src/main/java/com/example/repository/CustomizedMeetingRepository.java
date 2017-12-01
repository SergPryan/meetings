package com.example.repository;

import com.example.entity.Meeting;

import java.util.Collection;
import java.util.List;

public interface CustomizedMeetingRepository {
    List<Meeting> adasdadsad();
    Collection<Meeting> filterMeeting(String topic, String dateFrom, String dateTo, Long departmentId, Long responsible_id);
}
