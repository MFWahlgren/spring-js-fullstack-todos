package ek.osnb.demo.todosapp.todo;

public record CreateTodoRequest(
        String title,
        Long userId
) {}
