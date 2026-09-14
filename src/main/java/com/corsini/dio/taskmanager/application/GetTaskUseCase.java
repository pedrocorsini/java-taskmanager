package com.corsini.dio.taskmanager.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.corsini.dio.taskmanager.application.output.TaskOutput;
import com.corsini.dio.taskmanager.domain.TaskRepository;

@Service 
public class GetTaskUseCase {
    private final TaskRepository repository;

    public GetTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }
    
    public List<TaskOutput> exectute(){
        return repository.findAll().stream().map(TaskOutput::from).toList();
    }
    
}
