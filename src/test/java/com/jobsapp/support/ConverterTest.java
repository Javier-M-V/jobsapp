package com.jobsapp.support;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ConverterTest {
	
	@InjectMocks
	private Converter converter;

	@Test
	void secureLenght_null_returns_zero (){
		
		int result = converter.secureLenght(null);
		
		assertEquals(0, result);
	}
	
	@Test
	void secureLenght__non_null_string_returns_string_length (){
		
		int result = converter.secureLenght("ok");
		
		assertEquals(2, result);
	}
	
	@Test
	void iterable_to_list_returns_arraylist() {
		
		Integer foo[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		Iterable<Integer> iterable = Arrays.asList(foo);
		
		List<Integer> result = converter.toList(iterable);
		
		assertTrue(result instanceof ArrayList<?>);
	}
}
