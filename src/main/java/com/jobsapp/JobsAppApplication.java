package com.jobsapp;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.jobsapp.support.Job;



@SpringBootApplication
@EnableAsync
public class JobsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobsAppApplication.class, args);

		Job job = new Job();
		job.run();
	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("jobsapp");
		executor.initialize();
		return executor;
	}

	@Async
	public static CompletableFuture<String> todo(Long miliseconds) throws InterruptedException {

		Thread.sleep(1000L);
		return CompletableFuture.completedFuture("Test job executed at" + new Date().toString());
	}
}
