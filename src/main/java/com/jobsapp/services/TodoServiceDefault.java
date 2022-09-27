package com.jobsapp.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.jobsapp.api.IToDoService;
import com.jobsapp.models.ToDo;

@Service("TodoServiceDefault")
@Profile("default")
public class TodoServiceDefault implements IToDoService {

	@Override
	public void create(ToDo item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<ToDo> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public Collection<ToDo> getByStatus(boolean isCompleted) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public Collection<ToDo> getByUserId(long userId) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public Map<Boolean, Long> getStats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getTitles() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public void save(ToDo item) {
		// TODO Auto-generated method stub

	}
}
