package com.corsini.dio.taskmanager.application;

import org.springframework.stereotype.Service;

import com.corsini.dio.taskmanager.application.input.UpdateTaskInput;
import com.corsini.dio.taskmanager.application.output.TaskOutput;
import com.corsini.dio.taskmanager.domain.TaskId;
import com.corsini.dio.taskmanager.domain.TaskNotFoundException;
import com.corsini.dio.taskmanager.domain.TaskRepository;

@Service 
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id, UpdateTaskInput input){
        var task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.update(input.title(), input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutput.from(updated);
    }

}
