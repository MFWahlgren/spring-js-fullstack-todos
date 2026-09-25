package ek.osnb.demo.todosapp.todo;

import ek.osnb.demo.todosapp.user.Address;
import ek.osnb.demo.todosapp.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    @Test
    void createShouldStartIncomplete() {
        User user = User.create(
                "Ada Lovelace",
                "ada",
                "ada@example.com",
                Address.of("Main St", "Copenhagen", "2100", "Denmark")
        );

        Todo todo = Todo.create("Write tests", user);

        assertAll(
                () -> assertEquals("Write tests", todo.getTitle()),
                () -> assertSame(user, todo.getUser()),
                () -> assertFalse(todo.isCompleted())
        );
    }

    @Test
    void completeAndReopenShouldToggleCompletion() {
        User user = User.create(
                "Ada Lovelace",
                "ada",
                "ada@example.com",
                Address.of("Main St", "Copenhagen", "2100", "Denmark")
        );
        Todo todo = Todo.create("Write tests", user);

        todo.complete();
        assertTrue(todo.isCompleted());

        todo.reopen();
        assertFalse(todo.isCompleted());
    }

    @Test
    void updateTitleShouldReplaceTitle() {
        User user = User.create(
                "Ada Lovelace",
                "ada",
                "ada@example.com",
                Address.of("Main St", "Copenhagen", "2100", "Denmark")
        );
        Todo todo = Todo.create("Write tests", user);

        todo.updateTitle("Write more tests");

        assertEquals("Write more tests", todo.getTitle());
    }

    @Test
    void createShouldRejectNullTitleOrUser() {
        User user = User.create(
                "Ada Lovelace",
                "ada",
                "ada@example.com",
                Address.of("Main St", "Copenhagen", "2100", "Denmark")
        );

        assertThrows(NullPointerException.class, () -> Todo.create(null, user));
        assertThrows(NullPointerException.class, () -> Todo.create("Write tests", null));
    }

    @Test
    void updateTitleShouldRejectNull() {
        User user = User.create(
                "Ada Lovelace",
                "ada",
                "ada@example.com",
                Address.of("Main St", "Copenhagen", "2100", "Denmark")
        );
        Todo todo = Todo.create("Write tests", user);

        assertThrows(NullPointerException.class, () -> todo.updateTitle(null));
    }
}