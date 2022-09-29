package com.jobsapp.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jobsapp.api.IToDoService;

import com.jobsapp.models.ToDo;


@Service("TodoServiceDefault")
@Profile("default")
public class TodoServiceDefault implements IToDoService {


	@Value("${prop.url:https://jsonplaceholder.typicode.com/todos}")
	private String url;
	
	private final RestTemplate restTemplate;

	@Autowired
	public TodoServiceDefault (){
		restTemplate = new RestTemplate();
	}
	
	@Override
	public ToDo create(ToDo item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<ToDo> getAll() {
	
		ResponseEntity<ToDo[]>  data = restTemplate.getForEntity(url, ToDo[].class);
		return Arrays.asList(data.getBody());
	}


	@Override
	public Collection<ToDo> getByStatus(boolean isCompleted) {
		
		ResponseEntity<ToDo[]> data = restTemplate
				.getForEntity(url.concat("?completed=" + String.valueOf(isCompleted)), ToDo[].class);

		return Arrays.asList(data.getBody());
	}

	@Override
	public Collection<ToDo> getByUserId(long userId) {
		
		ResponseEntity<ToDo[]>  data = restTemplate.getForEntity(url.concat("?userId="+userId), ToDo[].class);
		
		return Arrays.asList(data.getBody());
	}

	@Override
	public Map<Boolean, Long> getStats() {
		
		ResponseEntity<ToDo[]> data = restTemplate.getForEntity(url, ToDo[].class);
		
		return Arrays.asList(data.getBody()).stream()
				.collect(Collectors.groupingBy(ToDo:: isCompleted, Collectors.counting()));
	}

	@Override
	public Collection<String> getTitles() {

		ResponseEntity<ToDo[]> data = restTemplate.getForEntity(url, ToDo[].class);
		
		return Arrays.asList(data.getBody()).stream()
				.map(ToDo::getTitle)
				.sorted((String a, String b) ->  a.length() - b.length())
				.collect(Collectors.toList());
	}
}
