package com.corsini.dio.taskmanager.infrastructure.http.request;

import java.util.Optional;

import com.corsini.dio.taskmanager.application.input.CreateTaskInput;

public record CreateTaskRequest(String title, Optional<String> description) {
    public CreateTaskInput toInput(){
        return new CreateTaskInput(title, description); 
    }
}
