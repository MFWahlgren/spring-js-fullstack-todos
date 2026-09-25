package ek.osnb.demo.todosapp.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
class TodoController {

    private final TodoService todoService;

    TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    List<TodoView> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    TodoView findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PostMapping
    ResponseEntity<TodoView> create(@RequestBody CreateTodoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(request));
    }

    @PatchMapping("/{id}/complete")
    TodoView complete(@PathVariable Long id) {
        return todoService.complete(id);
    }

    @PatchMapping("/{id}/reopen")
    TodoView reopen(@PathVariable Long id) {
        return todoService.reopen(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    TodoView update(@PathVariable Long id, @RequestBody UpdateTodoRequest request) {
        return todoService.update(id, request);
    }
}
