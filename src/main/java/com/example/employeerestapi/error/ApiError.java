package com.example.employeerestapi.error;

import java.time.LocalDateTime;
/**
 * 
 * @author vinod babu
 * 
 * Api Error model class which hold error details
 *
 */
public class ApiError {

	private String errorCode;
	private String errorMessage;
	private String details;
	private LocalDateTime timestamp;

	public ApiError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
