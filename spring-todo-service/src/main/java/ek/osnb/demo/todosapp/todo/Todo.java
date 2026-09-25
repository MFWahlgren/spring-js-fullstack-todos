package ek.osnb.demo.todosapp.todo;


import ek.osnb.demo.todosapp.user.User;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;

    @ManyToOne
    private User user;

    protected Todo() {
    }

    private Todo(String title, User user) {
        this.title = Objects.requireNonNull(title);
        this.user = Objects.requireNonNull(user);
        this.completed = false;
    }

    public static Todo create(String title, User user) {
        return new Todo(title, user);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public User getUser() {
        return user;
    }

    public void complete() {
        this.completed = true;
    }

    public void reopen() {
        this.completed = false;
    }

    public void updateTitle(String title) {
        this.title = Objects.requireNonNull(title);
    }
}
