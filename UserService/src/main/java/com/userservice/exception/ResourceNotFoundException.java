package com.userservice.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException () {
		super("Resource Not found..");
	}

	public ResourceNotFoundException (String msg) {
		super(msg);
	}
	
}
