package com.tcs.abn.recipeapi.exception;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponse extends ResponseEntityExceptionHandler{
	
	private LocalDateTime date= LocalDateTime.now();
	
	@ExceptionHandler(ResourceNoFoundException.class)
	public final ResponseEntity<Object> handleRecipeNotFoundException(ResourceNoFoundException  e, WebRequest request){
		
		ExceptionResponse excResponse= new ExceptionResponse(date, "Requested recipe does not exists ");
		
		 return new ResponseEntity<Object>(excResponse, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	  @ExceptionHandler(NoSuchElementException.class) public ResponseEntity<Object>
	  hadleNosuchElementException (NoSuchElementException e, WebRequest request){
	  ExceptionResponse excResponse= new
	  ExceptionResponse(date,"Recipe does not exists for requested action/id");
	  
	  return new ResponseEntity<Object>(excResponse, HttpStatus.BAD_REQUEST); }
	 

	

}
