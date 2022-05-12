/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.dao;


import com.mycompany.projectmanager.entities.Project;

import java.util.List;

/**
 *
 * @author Hugues
 */
public interface ProjectDAO extends GenericDAO<Project, Integer>{
    public List<Project>findAll();
    public long projectSize();
}
