package com.jobsapp.restcontrollers;

import java.util.Collection;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobsapp.api.IToDoService;
import com.jobsapp.dto.TodoDto;
import com.jobsapp.models.ToDo;

@RequestMapping("/odilo/tests")
@RestController
public class ToDoRestController {
	
	
	private static String PARAM_COMPLETED = "completed";
	
	@Autowired 
	private IToDoService todoService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	
	@GetMapping(value = "/1")
	public CollectionModel<ToDo> all(){
			
		return CollectionModel.of(todoService.getAll());
	}
	
	@PostMapping(value = "/2")
	public void newTodo (@RequestBody TodoDto dto){
		
		todoService.create(modelMapper.map(dto, ToDo.class));
	}
	
	@GetMapping(value = "/2")
	public CollectionModel<ToDo> allParam(@RequestParam(name = "status", required=false) String request){
		
		return CollectionModel.of(this.filterCompleted(request, todoService.getAll()));
	}

	private Collection<ToDo> filterCompleted(String request, Collection<ToDo> collection) {
		
		Predicate <ToDo> predicate;
	
		if(request != null) {
			
			if(PARAM_COMPLETED.equals(request)) {
				
				predicate = i -> (i.isCompleted() == true);
			}
			else {
				predicate = i -> (i.isCompleted() == false);
			}
			return collection.stream().filter(predicate).collect(Collectors.toList());
		}
		else {
			return collection;
		}		
	}
}
