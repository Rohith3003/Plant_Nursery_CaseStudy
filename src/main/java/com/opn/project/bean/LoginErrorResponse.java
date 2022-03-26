package com.opn.project.bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LoginErrorResponse {
	private int status;
	private String message;
	private LocalDateTime timeStamp;
}
