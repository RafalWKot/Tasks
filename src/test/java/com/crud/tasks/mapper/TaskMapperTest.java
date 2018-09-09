package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
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
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "my_task", "New task to do.");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertNotNull(task);
        assertEquals(1L, task.getId(), 0);
        assertEquals("my_task", task.getTitle());
        assertEquals("New task to do.", task.getContent());
    }

    @Test
    public void mapToTaskDto() {
        //Given
        Task task = new Task(1l, "my_task", "New task to do.");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertNotNull(taskDto);
        assertEquals(1l, taskDto.getId(), 0);
        assertEquals("my_task", taskDto.getTitle());
        assertEquals("New task to do.", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        Task task = new Task(1l, "my_task", "New task to do.");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertNotNull(taskDtoList);
        assertEquals(1, taskDtoList.size());

        taskDtoList.forEach(taskDto -> {
            assertEquals(1L, taskDto.getId(), 0);
            assertEquals("my_task", taskDto.getTitle());
            assertEquals("New task to do.", taskDto.getContent());
        });
    }

    @Test
    public void mapToTaskDtoEmptyList() {
        //Given
        List<Task> taskList = new ArrayList<>();

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertNotNull(taskDtoList);
        assertEquals(0, taskDtoList.size());
    }
}