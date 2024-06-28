package com.example.crud_wcd.dao;

import com.example.crud_wcd.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {
}