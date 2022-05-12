/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.dao;
import com.mycompany.projectmanager.entities.Company;
import java.util.List;

/**
 *
 * @author Hugues
 */
public interface CompanyDAO extends GenericDAO<Company, Integer>{
    public List<Company>findAll();
    public long companySize();
}
