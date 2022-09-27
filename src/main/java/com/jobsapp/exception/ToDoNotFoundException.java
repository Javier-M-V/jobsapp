package com.jobsapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ToDoNotFoundException extends ResponseStatusException {

	private static final long serialVersionUID = -5876326503324703605L;
	
	private static final String DESCRIPTION_404 = "ToDo not found, id: ";
	
	public ToDoNotFoundException(long id) {
		super(HttpStatus.NOT_FOUND, DESCRIPTION_404.concat(String.valueOf(id)));
	}
}
