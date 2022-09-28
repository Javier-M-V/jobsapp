package com.jobsapp.dto;

import java.io.Serializable;

import org.springframework.lang.NonNull;

public class TodoDto implements Serializable{
	
	private static final long serialVersionUID = -1245986449880540930L;

	private long id;
	
	@NonNull
	private boolean completed;
	
	@NonNull
	private String title;
	
	@NonNull
	private long userId;

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
