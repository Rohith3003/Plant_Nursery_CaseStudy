package com.cs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cs.bean.FertilizerErrorResponse;

@ControllerAdvice
public class FertilizerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<FertilizerErrorResponse> handleException(FertilizerNotFoundException exception)
	{
		FertilizerErrorResponse errorResponse = new FertilizerErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<FertilizerErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
