package com.jobsapp.services;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jobsapp.models.ToDo;
import com.jobsapp.repository.TodoRepository;

import com.jobsapp.support.Converter;

import junit.framework.TestCase;


@ExtendWith(MockitoExtension.class)
class TodoServiceH2Test extends TestCase{
	
	@InjectMocks
	private TodoServiceH2 todoServiceH2;
	
	@Mock
	private TodoRepository todoRepository;
	
	@Mock
	private Converter converter;
	
	static ToDo todo;
	
	@Before
	public void setUp() {
		
		todo = new ToDo();
	}

	@Test
	public void test_create_calls_save() {
	 
		Mockito.when(todoRepository.save(todo)).thenReturn(new ToDo());
		
		todoServiceH2.create(todo);
		
		Mockito.verify(todoRepository,Mockito.times(1)).save(todo);
	}
}
