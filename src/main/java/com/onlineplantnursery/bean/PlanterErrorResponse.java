package com.onlineplantnursery.bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PlanterErrorResponse {
	private int status;
	private String message;
	private LocalDateTime timestamp;
}
