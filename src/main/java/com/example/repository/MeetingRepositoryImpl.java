package com.example.repository;

import com.example.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MeetingRepositoryImpl implements CustomizedMeetingRepository {

    @Autowired
    private EntityManager entityManager;

    public Collection<Meeting> filterMeeting(String topic, String dateFrom, String dateTo, String departmentId, String responsibleId){
       String request = createRequestFilter(topic, dateFrom, dateTo, departmentId, responsibleId);
       System.out.println(request);
        Query query = entityManager.createNativeQuery(request,Meeting.class);
        return query.getResultList();
    }

    private String createRequestFilter(String topic, String dateFrom, String dateTo, String departmentId, String responsibleId){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM meeting");
        List<String> arguments = new ArrayList<>();
        if(topic != null && !topic.equalsIgnoreCase("null")){
            arguments.add("topic LIKE '%"+topic+"%'");
        }
        if(dateFrom != null && !dateFrom.equalsIgnoreCase("null")){
            arguments.add("date_time >= '" +dateFrom+"'");
        }
        if(dateTo != null && !dateTo.equalsIgnoreCase("null")){
            arguments.add("date_time <= '"+dateTo+"'");
        }
        if(departmentId != null && !departmentId.equalsIgnoreCase("null")){
            arguments.add("department_id  = "+departmentId);
            if(responsibleId != null && !responsibleId.equalsIgnoreCase("null")){
                arguments.add("responsible_id  = "+responsibleId);
            }
        }

        if(arguments.size() != 0){
            sb.append(" WHERE ");
            sb.append(String.join(" AND ",arguments));
        }
        return sb.toString();
    }
}
