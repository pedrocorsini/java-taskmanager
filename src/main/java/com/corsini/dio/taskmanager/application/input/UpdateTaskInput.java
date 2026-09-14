package com.corsini.dio.taskmanager.application.input;

import java.util.Optional;

import com.corsini.dio.taskmanager.domain.TaskStatus;

/**
 * UpdateTaskInput
 */
public record UpdateTaskInput(Optional<String> title, Optional<String> description, Optional<TaskStatus> status) {
}
