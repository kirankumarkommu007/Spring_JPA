package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    

    @PostMapping
    public List<Project> addProjects(@Validated @RequestBody List<Project> projects) {
        return projectService.addProjects(projects);
    }
}
