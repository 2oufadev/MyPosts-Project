package com.oufaaa.MyPosts.Exceptions;

import org.springframework.http.HttpStatus;

public class EmptySearchException extends RuntimeException {

	
	public EmptySearchException(String msg) {
		super(msg);
	}
	
	public HttpStatus getStatus() {
		return HttpStatus.NOT_ACCEPTABLE;
	}
}
