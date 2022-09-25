package com.jobsapp.api;

import java.util.Collection;
import java.util.Map;

import com.jobsapp.models.ToDo;

public interface IToDoService {
	
	public void  create(ToDo item);
	
	public Collection<ToDo> getAll();
	
	public Collection<ToDo> getByStatus(boolean isCompleted);

	public Collection<ToDo> getByUserId(long userId);
	
	public Map<Boolean, Long> getStats();
	
	public Collection<String> getTitles();
	
	public void save(ToDo item );
}