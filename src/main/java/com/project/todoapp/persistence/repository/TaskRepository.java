package com.project.todoapp.persistence.repository;

import com.project.todoapp.persistence.entity.Task;
import com.project.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TASK SET done = true WHERE id=:id", nativeQuery = true)
    public void markTaskAsFinisheed(@Param("id") Long id);
}
