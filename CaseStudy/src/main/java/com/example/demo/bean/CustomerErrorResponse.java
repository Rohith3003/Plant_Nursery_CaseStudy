package com.example.demo.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class CustomerErrorResponse {
	private int status;
	private String message;
	private LocalDate dateStamp;
	private LocalTime timeStamp;
	

}
