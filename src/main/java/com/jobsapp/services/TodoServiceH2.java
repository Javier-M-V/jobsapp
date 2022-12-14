package com.jobsapp.services;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.jobsapp.api.IToDoService;
import com.jobsapp.models.ToDo;
import com.jobsapp.repository.TodoRepository;
import com.jobsapp.support.Converter;


/**
 * 
 * Database service for H2 profile 
 * 
 * */
@Service("todoService")
@Profile("h2")
public class TodoServiceH2 implements IToDoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public ToDo create(ToDo item) {
		
		return todoRepository.save(item);
	}

	@Override
	public Collection<ToDo> getAll() {
		
		return converter.toList(todoRepository.findAll());
	}

	@Override
	public Collection<ToDo> getByStatus(boolean isCompleted) {
		
		return converter.toList(todoRepository.findByCompleted(isCompleted));
	}

	@Override
	public Collection<ToDo> getByUserId(long userId) {
		
		return converter.toList(todoRepository.findByUserId(userId));
	}

	@Override
	public Map<Boolean, Long> getStats() {
	
		return this.getAll().stream()
	            .collect(Collectors.groupingBy(ToDo:: isCompleted, Collectors.counting()));
	}

	@Override
	public Collection<String> getTitles() {
		
		 return this.getAll().stream()
				.map(ToDo :: getTitle)
				.sorted((String a , String b) -> converter.secureLenght(a) -converter.secureLenght(b))
				.collect(Collectors.toList());	 
	}
}
