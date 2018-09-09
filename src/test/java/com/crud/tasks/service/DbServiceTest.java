package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTest {

    @Autowired
    DbService dbService;

    @Test
    public void testGetAllTask() {
        //Given
        Task task = new Task(null, "my_task","My new task.");
        dbService.saveTask(task);

        //When
        List<Task> taskListFromDB = dbService.getAllTask();

        //Then
        assertNotNull(taskListFromDB);
        assertEquals(1, taskListFromDB.size());
        taskListFromDB.forEach(task1 -> {
            assertNotNull(task1.getId());
            assertEquals("my_task", task1.getTitle());
            assertEquals("My new task.", task1.getContent() );
        });

        //Clean Up
        dbService.deleteTask(taskListFromDB.get(0).getId());
    }

    @Test
    public void testGetAllTaskEmptyList() {
        //Given

        //When
        List<Task> taskListFromDB = dbService.getAllTask();

        //Then
        assertNotNull(taskListFromDB);
        assertEquals(0, taskListFromDB.size());
    }

    @Test
    public void testGetTask() {
        //Given
        Task task = new Task(null, "my_task","My new task.");
        Task taskToDB = dbService.saveTask(task);

        //When
        Task taskFromDB = dbService.getTask(taskToDB.getId()).get();

        //Then
        assertNotNull(taskFromDB);
        assertEquals(taskToDB.getId(), taskFromDB.getId());
        assertEquals("my_task", taskFromDB.getTitle());
        assertEquals("My new task.", taskFromDB.getContent());

        //Clean Up
        dbService.deleteTask(taskFromDB.getId());
    }

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task(null, "my_task","My new task.");

        //When
        Task taskToDB = dbService.saveTask(task);

        //Then
        assertEquals(taskToDB.getId(), dbService.getTask(taskToDB.getId()).get().getId());
        assertEquals("my_task", dbService.getTask(taskToDB.getId()).get().getTitle());
        assertEquals("My new task.", dbService.getTask(taskToDB.getId()).get().getContent());

        //Clean Up
        dbService.deleteTask(taskToDB.getId());
    }

    @Test
    public void testDeleteTask() {
        //Given
        Task task = new Task(null, "my_task","My new task.");
        Task taskToDB = dbService.saveTask(task);

        //When
        dbService.deleteTask(taskToDB.getId());
        List<Task> taskList = dbService.getAllTask();

        //Then
        assertNotNull(taskList);
        assertEquals(0, taskList.size());
    }
}