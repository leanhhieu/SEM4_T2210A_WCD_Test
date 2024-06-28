package com.example.examwcd.dao;

import com.example.examwcd.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeReponsitory extends CrudRepository<Employee, Integer> {
}
