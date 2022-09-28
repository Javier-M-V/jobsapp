package com.jobsapp.dto;


import java.io.Serializable;
import java.util.Map;

public class StatsDto implements Serializable{

	private static final long serialVersionUID = 6198320123550485890L;
	
	private Map<Boolean, Long> stats;
	
	public StatsDto (Map<Boolean, Long> stats) {
		
		this.setStats(stats);
	}

	public Map<Boolean, Long> getStats() {
		return stats;
	}

	public void setStats(Map<Boolean, Long> stats) {
		this.stats = stats;
	}
}
