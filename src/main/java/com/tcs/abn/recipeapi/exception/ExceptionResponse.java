package com.tcs.abn.recipeapi.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	private LocalDateTime date;
	private String message;
	public ExceptionResponse(LocalDateTime date, String message) {
		super();
		this.date = date;
		this.message = message;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}

		
	
	
}
