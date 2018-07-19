package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    @Autowired
    private DbService service;

    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<TaskDto> getTasks() {
        return  taskMapper.mapToTaskDtoList(service.getAllTask());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{taskId}")
    public TaskDto getTask(@PathVariable("taskId") Long taskId) {
        return taskMapper.mapToTaskDto(service.getTask(taskId));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteTask(Long taskId) {}

    @RequestMapping(method = RequestMethod.PUT)
    public TaskDto updateTask(TaskDto taskDto) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createTask(TaskDto taskDto){}
}
