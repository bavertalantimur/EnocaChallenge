package com.company.enoca.controller;

import com.company.enoca.dto.CompanyDto;
import com.company.enoca.dto.CompanyResponses;
import com.company.enoca.entities.Company;
import com.company.enoca.service.ICompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    ICompanyService companyService;
    private final ModelMapper modelMapper;

    public CompanyController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping("create")
    public ResponseEntity<CompanyResponses> create(@RequestBody CompanyDto companyDto){
        try {
            companyService.create(companyDto);
            return ResponseEntity.status(202).body(new CompanyResponses(202,"success","new company created"));
        }catch (Exception e){
            return ResponseEntity.status(424).body(new CompanyResponses(424,"fail","can not be created"));
        }

    }
    @PutMapping("update/{id}")
    public ResponseEntity<CompanyResponses> update(@RequestBody CompanyDto companyDto, @PathVariable Long id){
        try {
            companyService.update(companyDto,id);
            return ResponseEntity.status(200).body(new CompanyResponses(200,"success","company updated"));
        }catch (Exception e){
            return ResponseEntity.status(400).body(new CompanyResponses(400,"fail","can not be updated"));
        }
    }

    @GetMapping("all")
    public ResponseEntity<CompanyResponses> getAll(){
        try {
            List<CompanyDto> companyDtoList=companyService.getAll();
            return ResponseEntity.status(200).body(new CompanyResponses(200,"succes","all companies listed gracefully",companyDtoList));

        }catch (Exception e){
            return ResponseEntity.status(404).body(new CompanyResponses(400,"fail","all companies not listed"));
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<CompanyResponses> delete(@PathVariable Long id){
         try {
             companyService.delete(id);
             return ResponseEntity.status(204).body(new CompanyResponses(204,"success","successfully deleted"));
         }catch (Exception e){
             return ResponseEntity.status(400).body(new CompanyResponses(400,"fail","not deleted"));
         }
    }
    @GetMapping("{id}")
    public ResponseEntity<CompanyResponses> getCompanyById(@PathVariable Long id){
        try {
            CompanyDto companyDto=companyService.getCompanyById(id);
            return ResponseEntity.status(200).body(new CompanyResponses(200,"success","Company find by id",List.of(companyDto)));
        }catch (Exception e){
            return ResponseEntity.status(400).body(new CompanyResponses(400,"fail","not find id"));
        }
    }
    @GetMapping("/c/{id}")
    public Company getCompanyEmployeesById(@PathVariable Long id){
        return companyService.getCompanyEmployeesById(id);

    }


}
