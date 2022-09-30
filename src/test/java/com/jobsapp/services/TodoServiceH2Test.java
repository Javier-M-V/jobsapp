package com.jobsapp.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jobsapp.models.ToDo;
import com.jobsapp.repository.TodoRepository;

import com.jobsapp.support.Converter;


@ExtendWith(MockitoExtension.class)
class TodoServiceH2Test {
	
	@InjectMocks
	private TodoServiceH2 todoServiceH2;
	
	@Mock
	private TodoRepository todoRepository;
	
	@Mock
	private Converter converter;
	
	static ToDo todo;
	
	static List<ToDo> todoList;
	
	@BeforeAll
	public static void setUp() {
		
		todo = new ToDo();
		
		todo.setCompleted(true);
		todo.setId(2L);
		todo.setTitle("Homo homini lupus est");
		todo.setUserId(2L);
		
		ToDo todo2 = new ToDo();
		todo2.setCompleted(false);
		todo2.setId(3L);
		todo2.setTitle("SQPR");
		todo2.setUserId(3L);
		
		ToDo todo3 = new ToDo();
		todo3.setCompleted(false);
		todo3.setId(3L);
		//todo3.setTitle("alea jacta est");
		todo3.setTitle(null);
		todo3.setUserId(3L);
		
		todoList = new ArrayList<>();
		todoList.add(todo);
		todoList.add(todo2);
		todoList.add(todo3);
	}

	@Test
	void test_create_calls_save() {
	 
		Mockito.when(todoRepository.save(todo)).thenReturn(new ToDo());
		
		todoServiceH2.create(todo);
		
		Mockito.verify(todoRepository,Mockito.times(1)).save(todo);
	}
	
	@Test
	void test_getAll_calls_findAll() {
	 
		Mockito.when(todoRepository.findAll()).thenReturn(new ArrayList<>());
		
		todoServiceH2.getAll();
		
		Mockito.verify(todoRepository,Mockito.times(1)).findAll();
	}
	
	@Test
	void test_getByUserId_calls_findAll() {
	 
		Mockito.when(todoRepository.findByUserId(2L)).thenReturn(new ArrayList<>());
		
		todoServiceH2.getByUserId(2L);
		
		Mockito.verify(todoRepository,Mockito.times(1)).findByUserId(2L);
	}
	
	@Test
	void test_getStats_calls_findAll_return_one_element_true() {
	 
		Mockito.when(todoRepository.findAll()).thenReturn(todoList);
		Mockito.doCallRealMethod().when(converter).toList(todoList);
		
		Map<Boolean, Long> response = todoServiceH2.getStats();
		
		Mockito.verify(todoRepository,Mockito.times(1)).findAll();
		assertEquals(1L, response.get(true), 0);
		assertEquals(2L, response.get(false), 0);
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	void test_getTitles_getAll_sort_by_string_size_ok() {
		
		Mockito.when(todoRepository.findAll()).thenReturn(todoList);
		Mockito.doCallRealMethod().when(converter).toList(todoList);
		Mockito.doCallRealMethod().when(converter).secureLenght(Mockito.anyString());
		
	
		List<String> response = (ArrayList) todoServiceH2.getTitles();
		
		assertEquals(null, response.get(0));
		assertEquals(4, response.get(1).length());
		assertEquals(21, response.get(2).length());
	}	 
}
