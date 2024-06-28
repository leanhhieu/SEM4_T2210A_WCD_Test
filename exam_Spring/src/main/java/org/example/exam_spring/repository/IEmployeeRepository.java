package org.example.exam_spring.repository;

import org.example.exam_spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByPhoneNumber(String phoneNumber);
}
