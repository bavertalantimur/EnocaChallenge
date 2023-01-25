package com.company.enoca.controller;

import com.company.enoca.entities.Company;
import com.company.enoca.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    ICompanyService companyService;

    @PostMapping("create")
    public Company create(@RequestBody Company company){
        return companyService.create(company);
    }
    @PutMapping("update")
    public Company update(@RequestBody Company company){
        return companyService.update(company);
    }

    @GetMapping("all")
    public List<Company> getAll(){
        return companyService.getAll();
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
         return companyService.delete(id);
    }


}
