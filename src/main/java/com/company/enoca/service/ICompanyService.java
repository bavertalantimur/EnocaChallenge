package com.company.enoca.service;

import com.company.enoca.dto.CompanyDto;
import com.company.enoca.entities.Company;

import java.util.List;

public interface ICompanyService {
    void create(CompanyDto companyDto);
    void update(CompanyDto companyDto,Long id);

    List<CompanyDto> getAll();
    void delete(Long id);
    CompanyDto getCompanyById(Long id);
    Company getCompanyEmployeesById(Long id);

}
