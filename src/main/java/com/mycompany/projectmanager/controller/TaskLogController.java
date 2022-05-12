package com.mycompany.projectmanager.controller;

import com.mycompany.projectmanager.dao.TaskLogDAO;
import com.mycompany.projectmanager.entities.TaskLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/taskLogs")
public class TaskLogController {
    private final TaskLogDAO taskLogDAO;

    public TaskLogController(TaskLogDAO taskLogDAO) {
        this.taskLogDAO = taskLogDAO;
    }


    @GetMapping("/findTaskLogs")
    public ResponseEntity<List<TaskLog>> findTaskLog(){
        List<TaskLog> taskLogs = taskLogDAO.findAll();
        return new ResponseEntity<>(taskLogs, HttpStatus.OK);
    }
}
