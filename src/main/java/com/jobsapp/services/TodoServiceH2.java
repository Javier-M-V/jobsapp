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


@Service("todoService")
@Profile("h2")
public class TodoServiceH2 implements IToDoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public void create(ToDo item) {
		
		todoRepository.save(item);
	}

	@Override
	public Collection<ToDo> getAll() {
		
		return converter.toList(todoRepository.findAll());
	}
	
//	public Collection<ToDo> getAllCompleted() {
//		
//		return converter.toList(todoRepository.findAll()).stream().filter(i-> i.isCompleted()).toList();
//	}

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
				.map(ToDo :: getDescription)
				.sorted((String a , String b) -> a.length() -b.length())
				.collect(Collectors.toList());	 
	}

	@Override
	public void save(ToDo item) {
		
		todoRepository.save(item);
	}
}
