package com.example.task.repositories;

import com.example.task.models.ScheduleTime;
import com.example.task.models.TimeDiagram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository
public interface ScheduleTimeRepository extends JpaRepository<ScheduleTime, Long> {
    @Query(value="select new com.example.task.models.TimeDiagram(count(s.startTime), s.startTime, s.endTime)" + " from ScheduleTime s group by s.startTime, s.endTime")
    List<TimeDiagram> findTimeGroup();
}
