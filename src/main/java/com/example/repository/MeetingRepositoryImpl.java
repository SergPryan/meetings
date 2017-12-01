package com.example.repository;

import com.example.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class MeetingRepositoryImpl implements CustomizedMeetingRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Meeting> adasdadsad() {
        Query query = entityManager.createNativeQuery("SELECT * FROM meeting WHERE topic LIKE '%alpha%' AND " +
                "date_time > '2017-09-30' AND date_time < '2017-12-28' AND department_id = 3 AND responsible_id = 4",Meeting.class);
        List<Meeting> list = query.getResultList();
        System.out.println(list.get(0).getTopic());
        System.out.println("asdasd");
        return null;
    }


    public Collection<Meeting> filterMeeting(String topic, String dateFrom, String dateTo, Long departmentId, Long responsibleId){
       String request = createRequestFilter(topic, dateFrom, dateTo, departmentId, responsibleId);
       System.out.println(request);
        Query query = entityManager.createNativeQuery(request,Meeting.class);
        return query.getResultList();
    }

    private String createRequestFilter(String topic, String dateFrom, String dateTo, Long departmentId, Long responsibleId){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM meeting WHERE");
        if(topic != null){
            sb.append(" topic LIKE '%");
            sb.append(topic);
            sb.append("%'");
        }
        if(dateFrom != null){
            sb.append(" AND date_time >= ");
            sb.append("'");
            sb.append(dateFrom);
            sb.append("'");
        }
        if(dateTo != null){
            sb.append(" AND date_time <= ");
            sb.append("'");
            sb.append(dateTo);
            sb.append("'");
        }
        if(departmentId != null){
            sb.append(" AND department_id  = ");
            sb.append(departmentId);
        }
        if(responsibleId != null){
            sb.append(" AND responsible_id  = ");
            sb.append(departmentId);
        }
        return sb.toString();
    }
}
