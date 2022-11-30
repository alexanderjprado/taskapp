package com.project.todoapp.domain.service;

import com.project.todoapp.domain.dto.TaskInDto;
import com.project.todoapp.persistence.entity.Task;
import com.project.todoapp.persistence.entity.TaskStatus;
import com.project.todoapp.persistence.mapper.TaskInDTOToTask;
import com.project.todoapp.persistence.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService {

    //CONSTRUCTOR METHODS
    private final TaskInDTOToTask taskMapper;

    private final TaskRepository taskRepository;

    public TaskService(TaskInDTOToTask taskMapper, TaskRepository taskRepository) {
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }

    //CREATE A NEW TASK
    public Task createTask(TaskInDto taskInDto) {
        Task task = taskMapper.map(taskInDto);
        return this.taskRepository.save(task);
    }

    //GET ALL THE TASK
    public List<Task> getAllTask() {
        return this.taskRepository.findAll();
    }

    //GET ALL TASK BY STATUS
    public List<Task> findAllByStatus(TaskStatus status) {
        return this.taskRepository.findAllByTaskStatus(status);
    }

    //UPDATE TASK AS FINISHED
    @Transactional
    public void updateTaskAsFinished(Long id) {
        this.taskRepository.markTaskAsFinisheed(id);
    }
}
