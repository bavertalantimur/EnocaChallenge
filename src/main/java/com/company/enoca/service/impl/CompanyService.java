package com.company.enoca.service.impl;


import com.company.enoca.dao.ICompanyDao;
import com.company.enoca.dto.CompanyDto;
import com.company.enoca.dto.EmployeeDto;
import com.company.enoca.entities.Company;
import com.company.enoca.service.ICompanyService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CompanyService implements ICompanyService {
    @Autowired
    ICompanyDao companyDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(CompanyDto companyDto) {
        Company company=modelMapper.map(companyDto,Company.class);
        companyDao.create(company);
    }

    @Override
    public void update(CompanyDto companyDto,Long id) {
        Company company=modelMapper.map(companyDto,Company.class);
        company.setId(id);
        companyDao.update(company);
    }

    @Override
    public List<CompanyDto> getAll() {
        List<CompanyDto> companyDtos=new ArrayList<>();
        companyDao.getAll().forEach(company -> companyDtos.add(modelMapper.map(company,CompanyDto.class)));
        return companyDtos;
    }

    @Override
    public void delete(Long id) {
         companyDao.delete(id);
    }

    @Override
    public CompanyDto getCompanyById(Long id) {
        CompanyDto companyDto=modelMapper.map(companyDao.getCompanyById(id),CompanyDto.class);
        return companyDto;
    }

    @Override
    public Company getCompanyEmployeesById(Long id) {
        return companyDao.getCompanyEmployeesById(id);
    }

}
