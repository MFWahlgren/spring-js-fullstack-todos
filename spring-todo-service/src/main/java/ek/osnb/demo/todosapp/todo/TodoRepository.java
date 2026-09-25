package ek.osnb.demo.todosapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

interface TodoRepository extends JpaRepository<Todo, Long> {

    boolean existsByTitle(String title);
}
