package com.todo.todo.todo;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Todo(
        Integer id,
        @NotEmpty
        String todo,
        Boolean isComplete,
        LocalDateTime createdAt,
        LocalDateTime completedAt
) {
}
