package com.onlineplantnursery.exception;

public class PlanterNotFoundException extends RuntimeException{
	public PlanterNotFoundException()
	{
		super();
	}
	public PlanterNotFoundException(String message)
	{
		super(message);
	}
	public PlanterNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
