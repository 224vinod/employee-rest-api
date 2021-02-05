package com.example.employeerestapi.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeerestapi.entity.Employee;
import com.example.employeerestapi.repository.EmployeeRepository;
/**
 * 
 * @author vinod babu
 * 
 *Employee service class
 *
 */
@Service
public class EmployeeService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	public Optional<Employee> updateEmployee(Employee employee) {
		Optional<Employee> employeeToReturn = Optional.empty();
		Optional<Employee> employeeToUpdate = employeeRepository.findById(employee.getId());

		if (employeeToUpdate.isPresent()) {
			employeeToReturn = Optional.of(employeeRepository.save(employee));
		} else {
			logger.info("No Employee found with id" + employee.getId());
		}
		return employeeToReturn;
	}

	public Optional<Employee> deleteEmployee(Employee employee) {

		Optional<Employee> employeeToReturn = Optional.empty();
		Optional<Employee> employeeToDelete = employeeRepository.findById(employee.getId());

		if (employeeToDelete.isPresent()) {
			employeeRepository.delete(employeeToDelete.get());
			employeeToReturn = Optional.of(employeeToDelete.get());
		} else {
			logger.info("No Employee found with id" + employee.getId());
		}
		return employeeToReturn;
	}

}
