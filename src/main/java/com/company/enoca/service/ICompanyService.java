package com.company.enoca.service;

import com.company.enoca.entities.Company;

import java.util.List;

public interface ICompanyService {
    Company create(Company company);
    Company update(Company company);

    List<Company> getAll();
    String delete(Long id);

}
