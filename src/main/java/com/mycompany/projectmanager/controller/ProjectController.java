package com.mycompany.projectmanager.controller;

import com.mycompany.projectmanager.dao.ProjectDAO;
import com.mycompany.projectmanager.entities.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectDAO projectDAO;

    public ProjectController(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }


    @GetMapping("/findProjects")
    public ResponseEntity<List<Project>> findProject(){
        List<Project> projects = projectDAO.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/projectsSize")
    public ResponseEntity<Long> projectSize(){
        Long projSize = projectDAO.projectSize();
        return new ResponseEntity<>(projSize,HttpStatus.OK);
    }
}
