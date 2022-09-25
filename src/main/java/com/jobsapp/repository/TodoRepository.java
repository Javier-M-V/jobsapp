package com.jobsapp.repository;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.jobsapp.models.ToDo;



public interface TodoRepository extends CrudRepository<ToDo, Long> {
	
	public Collection<ToDo> findByCompleted(boolean completed);
	
	public Collection<ToDo> findByUserId(long id);
}
