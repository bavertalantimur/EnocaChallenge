package com.company.enoca.service.impl;


import com.company.enoca.dao.ICompanyDao;
import com.company.enoca.entities.Company;
import com.company.enoca.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    ICompanyDao companyDao;

    @Override
    public Company create(Company company) {
        return companyDao.create(company);
    }

    @Override
    public Company update(Company company) {
        return companyDao.update(company);
    }

    @Override
    public List<Company> getAll() {
        return companyDao.getAll();
    }

    @Override
    public String delete(Long id) {
        return companyDao.delete(id);
    }
}
