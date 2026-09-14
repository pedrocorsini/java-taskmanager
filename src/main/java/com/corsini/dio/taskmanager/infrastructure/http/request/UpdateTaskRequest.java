package com.corsini.dio.taskmanager.infrastructure.http.request;

import java.util.Optional;

import com.corsini.dio.taskmanager.application.input.UpdateTaskInput;
import com.corsini.dio.taskmanager.domain.TaskStatus;

/**
 * UpdateTaskRequest
 */
public record UpdateTaskRequest(
    Optional<String> title,
    Optional<String> description,
    Optional<String> status
) {

    public UpdateTaskInput toInput(){
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
    
}
