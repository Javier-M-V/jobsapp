package com.jobsapp.dto;

import java.util.ArrayList;
import java.util.List;

import com.jobsapp.models.ToDo;

public class TodoDtoList {

	private List<ToDo> todoList;
	
	public TodoDtoList() {
		
		this.todoList = new ArrayList<>();
	}

	public List<ToDo> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<ToDo> todoList) {
		this.todoList = todoList;
	}
}
