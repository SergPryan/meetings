package com.example.repository;

import com.example.entity.Meeting;

import java.util.Collection;
import java.util.List;

public interface CustomizedMeetingRepository {
    Collection<Meeting> filterMeeting(String topic, String dateFrom, String dateTo, String departmentId, String responsible_id);
}
