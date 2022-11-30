package com.project.todoapp.persistence.mapper;

public interface IMapper <I, O> {
    public O map(I in);
}
