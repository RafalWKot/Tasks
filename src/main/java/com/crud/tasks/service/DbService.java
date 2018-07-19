package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    TaskRepository repository;

    public List<Task> getAllTask() {
        return  repository.findAll();
    }

    //Czemu tej klasy nie muszę nadpisać??
    public Task getTask(Long id){
        return repository.findOne(id);
    }
}
