package com.company.enoca.dao.impl;

import com.company.enoca.dao.ICompanyDao;
import com.company.enoca.entities.Company;
;
import com.company.enoca.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDao implements ICompanyDao {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        companyRepository.deleteById(id);
        return "successfully deleted";
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company getCompanyEmployeesById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
