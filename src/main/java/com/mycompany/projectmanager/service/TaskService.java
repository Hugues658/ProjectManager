/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.service;

import com.mycompany.projectmanager.entities.Project;
import com.mycompany.projectmanager.entities.Task;
import com.mycompany.projectmanager.entities.TaskLog;
import com.mycompany.projectmanager.vo.Result;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface TaskService {

    public Result<Task> store(
            Integer idTask,
            Integer idProject,
            String taskName,
            String actionUsername);

    public Result<Task> remove(Integer idTask, String actionUsername);

    public Result<Task> find(Integer idTask, String actionUsername);

    public Result<List<Task>> findAll(String actionUsername);
}
