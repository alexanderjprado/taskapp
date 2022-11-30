package com.project.todoapp.persistence.mapper;

import com.project.todoapp.domain.dto.TaskInDto;
import com.project.todoapp.persistence.entity.Task;
import com.project.todoapp.persistence.entity.TaskStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDto, Task> {

    @Override
    public Task map(TaskInDto in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setDone(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
