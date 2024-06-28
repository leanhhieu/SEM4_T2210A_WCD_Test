package org.fai.example.Company.dao;

import org.fai.example.FinalExam.entity.Company;

import java.util.List;

public interface ICompanyDAO {
    void saveCompany(Company Company);
    Company getCompanyById(Long id);
    List<Company> getAllCompany();
}
