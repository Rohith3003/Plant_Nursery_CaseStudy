package com.opn.project.exception;

public class LoginExceptions extends RuntimeException{

	public LoginExceptions() {
		super();
		
	}

	public LoginExceptions(String message) {
		super(message);
		
	}

	public LoginExceptions(Throwable cause) {
		super(cause);
		
	}

}
