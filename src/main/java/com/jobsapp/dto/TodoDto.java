package com.jobsapp.dto;

import java.io.Serializable;

public class TodoDto implements Serializable{
	
	private static final long serialVersionUID = -1245986449880540930L;

	private long id;
	
	private boolean completed;

	private String description;
	
	private long userId;

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
