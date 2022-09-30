package com.jobsapp.support;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jobsapp.models.ToDo;

@ExtendWith(MockitoExtension.class)
class TodoFiltersTest {
	
	@InjectMocks
	private TodoFilters filter;
	
	static List<ToDo> listTodo;
	
	@BeforeAll
	public static void beforeAll() {
		
		ToDo todo = new ToDo();
		
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
		todo3.setTitle("alea jacta est");
		todo3.setUserId(3L);
		
		listTodo = new ArrayList<>();
		listTodo.add(todo);
		listTodo.add(todo2);
		listTodo.add(todo3);
	}
	
	@Test
	void test_filterCompleted_true_returns_one() {
		
		Collection<ToDo> colection = filter.filterCompleted("true", listTodo);
	
		assertEquals(1,((List<ToDo>)colection).size());
	}
	
	@Test
	void test_filterCompleted_true_returns_two() {
		
		Collection<ToDo> colection = filter.filterCompleted("false", listTodo);
		
		assertEquals(2,((List<ToDo>)colection).size());
	}
	
	@Test
	void test_filterCompleted_true_returns_same_collection() {
		
		Collection<ToDo> colection = filter.filterCompleted(null, listTodo);
		
		assertEquals(3,((List<ToDo>)colection).size());
	}
}
