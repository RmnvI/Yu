package com.example.task.controllers;

import com.example.task.models.TimeDiagram;
import com.example.task.models.api.TimeDiagramApiModel;
import com.example.task.repositories.ScheduleTimeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScheduleTimeController {
    private ScheduleTimeRepository repository;

    public ScheduleTimeController(ScheduleTimeRepository repository) {
        this.repository = repository;
    }

    /**
     * Method need to get group scheduleTimes for creating chart
     * @return
     */
    @GetMapping("diagramInfo")
    public List<TimeDiagramApiModel> getScheduleTimesDiagram(){
        List<TimeDiagram> diagrams = repository.findTimeGroup();
        List<TimeDiagramApiModel> diags = new ArrayList<>();
        for (TimeDiagram t:
             diagrams) {
            diags.add(new TimeDiagramApiModel(t.getCount(), t.getStart().toString(), t.getEnd().toString()));
        }
        return diags;
    }

}
