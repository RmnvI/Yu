package com.example.task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    /**
     * Method need to redirect to index page
     * @return
     */
    @GetMapping("/")
    public String getMainPage(){
        return "index";
    }

    /**
     * Method need to redirect to diagram page
     * @return
     */
    @GetMapping("/diagrams")
    public String getDiagramsPage(){
        return "diagram";
    }
}
