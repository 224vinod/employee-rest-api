package com.example.employeerestapi.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeerestapi.entity.Employee;
import com.example.employeerestapi.error.ApiError;
import com.example.employeerestapi.service.EmployeeService;
/**
 * 
 * @author vinod babu
 *
 */
@RestController
public class EmployeeApiController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	EmployeeService employeeService;

	@GetMapping(path = "/employee")
	public ResponseEntity<?> getAllEmployees() {

		ResponseEntity<?> returnResponse = null;
		List<Employee> employees;
		try {
			employees = employeeService.getAllEmployees();
			returnResponse = ResponseEntity.ok(employees);
		} catch (Exception e) {
			logger.error("Error in getAllEmployees", e);
			ApiError apiError = new ApiError();
			apiError.setErrorCode("ER01");
			apiError.setErrorMessage("Error in getting employee data");
			apiError.setDetails(e.getMessage());
			apiError.setTimestamp(LocalDateTime.now());
			returnResponse = new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return returnResponse;
	}
	
	@GetMapping(path = "/employee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable(name = "id") Long id) {
		ResponseEntity<?> returnResponse = null;
		try {
			
			Optional<Employee> employeeUpdated = employeeService.getEmployeeById(id);
			if (employeeUpdated.isPresent()) {
				returnResponse = ResponseEntity.ok(employeeUpdated.get());
			} else {
				returnResponse = ResponseEntity.notFound().build();
				ApiError apiError = new ApiError();
				apiError.setErrorCode("ER04");
				apiError.setErrorMessage("No employee data available with id " + id);
				apiError.setTimestamp(LocalDateTime.now());
				returnResponse = new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Error in getEmployee data", e);
			ApiError apiError = new ApiError();
			apiError.setErrorCode("ER03");
			apiError.setErrorMessage("Error in getting employee data");
			apiError.setDetails(e.getMessage());
			apiError.setTimestamp(LocalDateTime.now());
			returnResponse = new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return returnResponse;
	}

	@PostMapping(path = "/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		ResponseEntity<?> returnResponse = null;

		try {
			employeeService.addEmployee(employee);
			returnResponse = ResponseEntity.ok(employeeService.addEmployee(employee));
		} catch (Exception e) {
			logger.error("Error in addEmployee", e);
			ApiError apiError = new ApiError();
			apiError.setErrorCode("ER02");
			apiError.setErrorMessage("Unable to add employee");
			apiError.setDetails(e.getMessage());
			apiError.setTimestamp(LocalDateTime.now());
			returnResponse = new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return returnResponse;
	}

	@PutMapping(path = "/employee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
		ResponseEntity<?> returnResponse = null;
		try {
			employee.setId(id);
			Optional<Employee> employeeUpdated = employeeService.updateEmployee(employee);
			if (employeeUpdated.isPresent()) {
				returnResponse = ResponseEntity.ok(employeeUpdated.get());
			} else {
				returnResponse = ResponseEntity.notFound().build();
				ApiError apiError = new ApiError();
				apiError.setErrorCode("ER04");
				apiError.setErrorMessage("No employee data available with id " + id);
				apiError.setTimestamp(LocalDateTime.now());
				returnResponse = new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Error in updateEmployee", e);
			ApiError apiError = new ApiError();
			apiError.setErrorCode("ER03");
			apiError.setErrorMessage("Error in updating employee data");
			apiError.setDetails(e.getMessage());
			apiError.setTimestamp(LocalDateTime.now());
			returnResponse = new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return returnResponse;
	}

	@DeleteMapping(path = "/employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(name = "id") Long id) {
		ResponseEntity<?> returnResponse = null;
		try {
			Employee employeeToDelete = new Employee();
			employeeToDelete.setId(id);
			Optional<Employee> employeeUpdated = employeeService.deleteEmployee(employeeToDelete);
			if (employeeUpdated.isPresent()) {
				returnResponse = ResponseEntity.ok(employeeUpdated.get());
			} else {
				returnResponse = ResponseEntity.notFound().build();
				ApiError apiError = new ApiError();
				apiError.setErrorCode("ER04");
				apiError.setErrorMessage("No employee data available with id " + id);
				apiError.setTimestamp(LocalDateTime.now());
				returnResponse = new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Error in deleteEmployee", e);
			ApiError apiError = new ApiError();
			apiError.setErrorCode("ER03");
			apiError.setErrorMessage("Error in updating employee data");
			apiError.setDetails(e.getMessage());
			apiError.setTimestamp(LocalDateTime.now());
			returnResponse = new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return returnResponse;
	}
}
