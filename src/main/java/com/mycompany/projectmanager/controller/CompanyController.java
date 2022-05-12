package com.mycompany.projectmanager.controller;

import com.mycompany.projectmanager.dao.CompanyDAO;
import com.mycompany.projectmanager.entities.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyDAO companyDAO;

    public CompanyController(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }


    @GetMapping("/findCompanies")
    public ResponseEntity<List<Company>> FindCompany() {
        List<Company> companies = companyDAO.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }


    @GetMapping("/companiesSize")
    public ResponseEntity<Long> projectSize(){
        Long compSize = companyDAO.companySize();
        return new ResponseEntity<>(compSize,HttpStatus.OK);
    }
}
