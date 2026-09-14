package com.corsini.dio.taskmanager.infrastructure.http;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corsini.dio.taskmanager.application.CreateTaskUseCase;
import com.corsini.dio.taskmanager.application.GetTaskByIdUseCase;
import com.corsini.dio.taskmanager.application.GetTaskUseCase;
import com.corsini.dio.taskmanager.domain.TaskId;
import com.corsini.dio.taskmanager.infrastructure.http.request.CreateTaskRequest;
import com.corsini.dio.taskmanager.infrastructure.http.response.TaskResponse;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    private final GetTaskUseCase getTaskUseCase;
    private final GetTaskByIdUseCase getTaskByIdUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase, GetTaskUseCase getTaskUseCase, GetTaskByIdUseCase getTaskByIdUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTaskUseCase = getTaskUseCase;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
    }

    @PostMapping  
    TaskResponse create(@RequestBody CreateTaskRequest request){
        var input = request.toInput();
        var output = createTaskUseCase.execute(input);
        return TaskResponse.from(output);
    }

    @GetMapping  
    List<TaskResponse> list(){
        return getTaskUseCase.exectute().stream().map(TaskResponse::from).toList();
    }

    @GetMapping("/{id}")
    TaskResponse read(@PathVariable UUID id){
        var output = getTaskByIdUseCase.execute(new TaskId(id));
        return  TaskResponse.from(output);
    }
    
}
