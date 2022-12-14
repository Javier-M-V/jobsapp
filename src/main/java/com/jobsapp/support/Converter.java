package com.jobsapp.support;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;


@Component
public class Converter {

	public <T> List <T> toList (Iterable<T> element){
		
		return StreamSupport.stream(element.spliterator(), false)
			    .collect(Collectors.toList());
	}
	public int secureLenght(String a) {
		
		return Optional.ofNullable(a).map(String::length).orElse(0);
	}
}
