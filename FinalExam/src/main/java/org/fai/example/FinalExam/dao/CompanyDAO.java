package org.fai.example.FinalExam.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.fai.example.FinalExam.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAO implements CompanyDAO{
    private final EntityManager entityManager;
    @Autowired
    public CompanyDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void saveCompany(Company classRoom) {
        this.entityManager.persist(Company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return this.entityManager.find(Company.company, id);
    }

    @Override
    public List<Company> getAllClassRooms() {
        return this.entityManager.createQuery("from Company", Company.company).getResultList();
    }
}
