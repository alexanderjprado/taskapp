package com.project.todoapp.web.controller;

import com.project.todoapp.domain.dto.TaskInDto;
import com.project.todoapp.domain.service.TaskService;
import com.project.todoapp.persistence.entity.Task;
import com.project.todoapp.persistence.entity.TaskStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
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

    @GetMapping(path = "/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status")TaskStatus status) {
        return this.taskService.findAllByStatus(status);
    }

    @PatchMapping("/task/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id")Long id) {
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }
}