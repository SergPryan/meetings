package com.example.repository;

import com.example.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long>, CustomizedMeetingRepository {
    List<Meeting> findAllByTopicLikeAndDateTimeGreaterThanAndDateTimeLessThan (String topic, LocalDateTime dateFrom,LocalDateTime dateTo);
}
