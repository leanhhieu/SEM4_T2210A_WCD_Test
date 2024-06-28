package org.fai.example.Company.dao;

import org.fai.example.demo_spring_01.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company,Integer> {
}