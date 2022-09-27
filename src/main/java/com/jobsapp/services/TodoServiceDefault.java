package com.jobsapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jobsapp.api.IToDoService;

import com.jobsapp.models.ToDo;


@Service("TodoServiceDefault")
@Profile("default")
public class TodoServiceDefault implements IToDoService {


	private static String URL = "https://jsonplaceholder.typicode.com/todos";
	
	private final RestTemplate restTemplate;

	@Autowired
	public TodoServiceDefault (){
		restTemplate = new RestTemplate();
	}
	
	@Override
	public void create(ToDo item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<ToDo> getAll() {
	
		ResponseEntity<ToDo[]>  data = restTemplate.getForEntity(URL, ToDo[].class);
		return Arrays.asList(data.getBody());
	}


	@Override
	public Collection<ToDo> getByStatus(boolean isCompleted) {
		
		ResponseEntity<ToDo[]> data = restTemplate
				.getForEntity(URL.concat("?completed=" + String.valueOf(isCompleted)), ToDo[].class);

		return Arrays.asList(data.getBody());
	}

	@Override
	public Collection<ToDo> getByUserId(long userId) {
		
		ResponseEntity<ToDo[]>  data = restTemplate.getForEntity(URL.concat("?userId="+userId), ToDo[].class);
		
		return Arrays.asList(data.getBody());
	}

	@Override
	public Map<Boolean, Long> getStats() {
		
		ResponseEntity<ToDo[]> data = restTemplate.getForEntity(URL, ToDo[].class);
		
		return Arrays.asList(data.getBody()).stream()
				.collect(Collectors.groupingBy(ToDo:: isCompleted, Collectors.counting()));
	}

	@Override
	public Collection<String> getTitles() {

		ResponseEntity<ToDo[]> data = restTemplate.getForEntity(URL, ToDo[].class);
		
		return Arrays.asList(data.getBody()).stream()
				.map(ToDo::getDescription)
				.sorted((String a, String b) -> a.length() - b.length())
				.collect(Collectors.toList());
	}
}
