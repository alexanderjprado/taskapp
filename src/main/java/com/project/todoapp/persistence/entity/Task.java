package com.project.todoapp.persistence.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "task")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @NonNull
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private Boolean done;
    private TaskStatus taskStatus;
}
