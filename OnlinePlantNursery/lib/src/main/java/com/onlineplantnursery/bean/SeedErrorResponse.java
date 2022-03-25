package com.onlineplantnursery.bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SeedErrorResponse {
	private int status;
	public int getStatus() {
		return status;
	}
	
	/*public void setStatus(int value) {
		// TODO Auto-generated method stub
		
	}
	public void setMessage(String message2) {
		// TODO Auto-generated method stub
		
	}
	public void setTimestamp(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}*/
}
