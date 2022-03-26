package com.opn.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.opn.project.bean.LoginErrorResponse;

@ControllerAdvice
public class LoginExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<LoginErrorResponse> handleException(LoginExceptions exception){
		LoginErrorResponse error = new LoginErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
