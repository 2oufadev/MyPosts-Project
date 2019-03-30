package com.oufaaa.MyPosts.Exceptions;

import java.util.Date;

public class ExceptionDetails {
	
	private String message;
	private String uri;
	private Date date;
	
	
	public ExceptionDetails(String message, String uri, Date date) {
		super();
		this.message = message;
		this.uri = uri;
		this.date = date;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getUri() {
		return uri;
	}


	public void setUri(String uri) {
		this.uri = uri;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
