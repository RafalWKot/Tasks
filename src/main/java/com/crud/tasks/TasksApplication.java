package com.crud.tasks;

import com.crud.tasks.domain.TaskDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TasksApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TasksApplication.class, args);
		TaskDto taskDto = new TaskDto((long) 1, "Test title", "Test content");

		System.out.println(taskDto.getTitle());
	}
}