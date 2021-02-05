package com.example.employeerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeerestapi.entity.Employee;
/**
 * 
 * @author winner
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
