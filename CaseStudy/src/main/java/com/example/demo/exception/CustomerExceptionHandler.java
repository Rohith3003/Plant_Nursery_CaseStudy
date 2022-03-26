package com.example.demo.exception;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.bean.CustomerErrorResponse;



@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception) {
CustomerErrorResponse error = new CustomerErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setDateStamp(LocalDate.now());
		error.setTimeStamp(LocalTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<CustomerErrorResponse> handleException(DataIntegrityViolationException exception) {
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(exception.getMessage());
		error.setDateStamp(LocalDate.now());
		error.setTimeStamp(LocalTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(InvalidDataAccessResourceUsageException exception) {
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(exception.getMessage());
		error.setDateStamp(LocalDate.now());
		error.setTimeStamp(LocalTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(PasswordDoNotMatchException exception) {
CustomerErrorResponse error = new CustomerErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setDateStamp(LocalDate.now());
		error.setTimeStamp(LocalTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}
