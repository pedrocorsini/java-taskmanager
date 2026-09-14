package com.corsini.dio.taskmanager.application;

import org.springframework.stereotype.Service;

import com.corsini.dio.taskmanager.application.input.CreateTaskInput;
import com.corsini.dio.taskmanager.application.output.TaskOutput;
import com.corsini.dio.taskmanager.domain.Task;
import com.corsini.dio.taskmanager.domain.TaskRepository;

@Service 
public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository){
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input){
        var task = new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(saved);
    }
}
