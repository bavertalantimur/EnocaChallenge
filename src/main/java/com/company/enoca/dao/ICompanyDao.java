package com.company.enoca.dao;

import com.company.enoca.entities.Company;

import java.util.List;

public interface ICompanyDao {
    Company create(Company company);
    Company update(Company company);
    List<Company> getAll();

    String delete(Long id);

    Company getCompanyById(Long id);

    Company getCompanyEmployeesById(Long id);
}
