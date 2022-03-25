package com.onlineplantnursery.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.onlineplantnursery.bean.PlantErrorResponse;
@ControllerAdvice
public class PlantExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<PlantErrorResponse> handleException(PlantNotFoundException exception)
	{
		PlantErrorResponse error=new PlantErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<PlantErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
}
