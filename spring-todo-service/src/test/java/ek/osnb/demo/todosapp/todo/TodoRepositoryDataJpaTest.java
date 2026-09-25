package ek.osnb.demo.todosapp.todo;

import ek.osnb.demo.todosapp.user.Address;
import ek.osnb.demo.todosapp.user.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class TodoRepositoryDataJpaTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void existsByTitleShouldReturnTrueWhenTodoExists() {
        User user = User.create(
                "Ada Lovelace",
                "ada",
                "ada@example.com",
                Address.of(
                        "Main St",
                        "Copenhagen",
                        "2100",
                        "Denmark"
                )
        );

        Todo todo = Todo.create(
                "Write tests",
                user
        );

        entityManager.persist(user);
        entityManager.persist(todo);
        entityManager.flush();
        entityManager.clear();

        boolean exists = todoRepository.existsByTitle("Write tests");

        assertThat(exists).isTrue();
    }

    @Test
    void existsByTitleShouldReturnFalseWhenTodoDoesNotExist() {
        User user = User.create(
                "Ada Lovelace",
                "ada",
                "ada@example.com",
                Address.of(
                        "Main St",
                        "Copenhagen",
                        "2100",
                        "Denmark"
                )
        );

        Todo todo = Todo.create(
                "Existing title",
                user
        );

        entityManager.persist(user);
        entityManager.persist(todo);
        entityManager.flush();
        entityManager.clear();

        boolean exists = todoRepository.existsByTitle("Missing title");

        assertThat(exists).isFalse();
    }
}