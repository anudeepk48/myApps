package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="Access Denied")
public class AccessDenied extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public AccessDenied(){
		super("Access Denied");
	}
} 
