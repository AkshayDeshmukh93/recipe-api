package com.tcs.abn.recipeapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNoFoundException extends RuntimeException{

	public ResourceNoFoundException(String message) {
		super(message);
		
	}

}
