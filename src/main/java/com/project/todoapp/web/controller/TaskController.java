package com.project.todoapp.web.controller;

import com.project.todoapp.domain.dto.TaskInDto;
import com.project.todoapp.domain.service.TaskService;
import com.project.todoapp.persistence.entity.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    //CONSTRUCTOR METHODS
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDto taskInDto) {
        return this.taskService.createTask(taskInDto);
    }

    @GetMapping(path = "/")
    public List<Task> getAllTask() {
        return this.taskService.getAllTask();
    }
}