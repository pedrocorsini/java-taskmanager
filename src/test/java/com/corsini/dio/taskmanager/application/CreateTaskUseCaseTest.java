package com.corsini.dio.taskmanager.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.corsini.dio.taskmanager.application.input.CreateTaskInput;
import com.corsini.dio.taskmanager.application.output.TaskOutput;
import com.corsini.dio.taskmanager.domain.Task;
import com.corsini.dio.taskmanager.domain.TaskRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CreateTaskUseCaseTest {
    @Mock
    TaskRepository repository;

    @InjectMocks
    CreateTaskUseCase useCase;

    @Test
    void should_create_task_sucessfully(){
        // given
        var input = new CreateTaskInput("Estudar Java", Optional.of("Finalizar o módulo de Records")); 
        
        when(repository.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // when
        TaskOutput output = useCase.execute(input);

        // then
        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals("Estudar Java", output.title());
        assertEquals(Optional.of("Finalizar o módulo de Records"), output.description());

        verify(repository, times(1)).save(any(Task.class));
    }
}
