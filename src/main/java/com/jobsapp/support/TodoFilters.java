package com.jobsapp.support;


import java.util.Collection;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jobsapp.models.ToDo;

@Component
public class TodoFilters {

	public Collection<ToDo> filterCompleted(String request, Collection<ToDo> collection) {
		
		Predicate <ToDo> predicate;
	
		if(request != null) {
			
			predicate = i -> (i.isCompleted() == Boolean.valueOf(request));

			return collection.stream().filter(predicate).collect(Collectors.toList());
		}
		else {
			return collection;
		}		
	}
}
