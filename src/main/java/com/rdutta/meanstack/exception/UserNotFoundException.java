package com.rdutta.meanstack.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
		super(message);
	}
}
