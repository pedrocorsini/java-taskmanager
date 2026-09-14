package com.corsini.dio.taskmanager.application;

import org.springframework.stereotype.Service;

import com.corsini.dio.taskmanager.domain.TaskId;
import com.corsini.dio.taskmanager.domain.TaskNotFoundException;
import com.corsini.dio.taskmanager.domain.TaskRepository;

@Service 
public class DeleteTaskUseCase {
    private final TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(TaskId taskId){
        if(repository.findById(taskId).isEmpty()){
            throw new TaskNotFoundException(taskId);
        }
        repository.delete(taskId);
    }

}
