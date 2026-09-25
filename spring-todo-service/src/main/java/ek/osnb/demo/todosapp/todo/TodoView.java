package ek.osnb.demo.todosapp.todo;

public record TodoView(
        Long id,
        Long userId,
        String title,
        boolean completed
) {
    public static TodoView from(Todo todo) {
        return new TodoView(
                todo.getId(),
                todo.getUser().getId(),
                todo.getTitle(),
                todo.isCompleted()
        );
    }
}
