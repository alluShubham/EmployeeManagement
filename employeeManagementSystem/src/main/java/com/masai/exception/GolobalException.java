package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GolobalException {
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyError> employeeException(EmployeeException ex, WebRequest wR){
		MyError err = new MyError();
		err.setLdt(LocalDateTime.now());
		err.setDesc(wR.getDescription(false));
		err.setMsg(ex.getMessage());
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<MyError> departmentException(DepartmentException ex, WebRequest wR){
		MyError err = new MyError();
		err.setLdt(LocalDateTime.now());
		err.setDesc(wR.getDescription(false));
		err.setMsg(ex.getMessage());
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> noHandlerFoundException(NoHandlerFoundException ex, WebRequest wR){
		MyError err = new MyError();
		err.setLdt(LocalDateTime.now());
		err.setDesc(wR.getDescription(false));
		err.setMsg(ex.getMessage());
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_GATEWAY);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> exception(Exception ex, WebRequest wR){
		MyError err = new MyError();
		err.setLdt(LocalDateTime.now());
		err.setDesc(wR.getDescription(false));
		err.setMsg(ex.getMessage());
		
		return new ResponseEntity<MyError>(err, HttpStatus.BAD_REQUEST);
	}

}
