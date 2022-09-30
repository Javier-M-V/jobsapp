package com.jobsapp.restcontrollers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobsapp.api.IToDoService;
import com.jobsapp.dto.StatsDto;
import com.jobsapp.dto.TitlesDto;
import com.jobsapp.dto.TodoDto;
import com.jobsapp.models.ToDo;
import com.jobsapp.support.Converter;
import com.jobsapp.support.TodoFilters;

/***
 * 
 * Main Controller for odilo API
 * */
@RequestMapping("/odilo/tests")
@RestController
@Validated
public class ToDoRestController {
	
	@Autowired 
	private IToDoService todoService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private Converter converter;
	
	@Autowired
	private TodoFilters todoFilters;
	
	
	@GetMapping(value = "/1")
	public CollectionModel<ToDo> all(){
			
		return CollectionModel.of(todoService.getAll());
	}
	
	@PostMapping(value = "/2")
	public EntityModel<ToDo> newTodo (@RequestBody @Validated TodoDto todoDto){
		
		return EntityModel.of(todoService.create(modelMapper.map(todoDto, ToDo.class)));
	}
	
	@GetMapping(value = "/2")
	public CollectionModel<ToDo> allParam(@RequestParam(name = "completed", required=false) String request){
		
		return CollectionModel.of(todoFilters.filterCompleted(request, todoService.getAll()));
	}
	
	@GetMapping(value = "/2/user/{userid}")
	public CollectionModel<ToDo> byUserId(@PathVariable String userid){
		
		return CollectionModel.of(todoService.getByUserId(Long.parseLong(userid)));
	}
	
	@GetMapping(value = "/2/stats")
	public EntityModel<StatsDto> stats(){
		
		StatsDto dto = new StatsDto(todoService.getStats());
		
		return EntityModel.of(dto);
	}
	
	@GetMapping(value = "/2/titles")
	public EntityModel<TitlesDto> titles(){
		
		TitlesDto dto = new TitlesDto(converter.toList(todoService.getTitles()));
		
		return EntityModel.of(dto);
	}
}
