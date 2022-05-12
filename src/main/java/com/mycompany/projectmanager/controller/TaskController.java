package com.mycompany.projectmanager.controller;


import com.mycompany.projectmanager.dao.TaskDAO;
import com.mycompany.projectmanager.entities.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskDAO taskDAO;

    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @CrossOrigin("*")
    @GetMapping("/findTasks")
    public ResponseEntity<List<Task>> findTask(){
        List<Task> tasks = taskDAO.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping("/tasksSize")
    public ResponseEntity<Long> taskSize(){
        Long takSize = taskDAO.taskSize();
        return new ResponseEntity<>(takSize,HttpStatus.OK);
    }
}
