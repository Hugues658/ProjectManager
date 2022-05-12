/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.service;

/**
 *
 * @author Administrateur
 */
import com.mycompany.projectmanager.entities.Company;
import com.mycompany.projectmanager.vo.Result;
import java.util.List;

public interface CompanyService {

    public Result<Company> store(Integer idCompany,String companyName,String actionUsername);

    public Result<Company> remove(Integer idCompany,String actionUsername);

    public Result<Company> find(Integer idCompany,String actionUsername);

    public Result<List<Company>> findAll(String actionUsername);
}
