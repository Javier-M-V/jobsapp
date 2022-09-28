package com.jobsapp.dto;

import java.util.List;

public class TitlesDto {
	
	private List<String> titles;
	
	public TitlesDto(List<String> titles) {
		this.setTitles(titles);
	}

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
}
