package com.jobsapp.support;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:custom.properties")
public class Job {

	@Value("${miliseconds}")
	private  String miliseconds;

	public void run() {

		try {
			Thread.sleep(5000L);
			while (true) {
				CompletableFuture<String> exit = todo(1000L);
				System.out.println(exit.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Async
	private CompletableFuture<String> todo(Long miliseconds) throws InterruptedException {

		Thread.sleep(miliseconds);
		return CompletableFuture.completedFuture("Test job executed at " + new Date().toString());
	}
}
