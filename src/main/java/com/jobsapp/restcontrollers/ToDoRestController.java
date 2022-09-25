package com.jobsapp.restcontrollers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobsapp.api.IToDoService;
import com.jobsapp.dto.TodoDto;
import com.jobsapp.models.ToDo;

@RequestMapping("/odilo/tests")
@RestController
public class ToDoRestController {
	
	@Autowired 
	private IToDoService todoService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	
	@GetMapping(value = "/1")
	public CollectionModel<ToDo> all(){
			
		return CollectionModel.of(todoService.getAll());
	}
	
	@PostMapping(value = "/3")
	public void newTodo (@RequestBody TodoDto dto){
		
		todoService.save(modelMapper.map(dto, ToDo.class));
	}
}
