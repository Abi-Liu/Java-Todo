package com.todo.todo.todo;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepository {
    private final JdbcClient jdbcClient;

    public TodoRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Todo> findAll() {
        return this.jdbcClient.sql("select * from todo").query(Todo.class).list();
    }

    public Optional<Todo> findById(Integer id) {
        return this.jdbcClient.sql("select * from todo where id = :id").param("id", id).query(Todo.class).optional();
    }

    public void create(Todo todo) {
        this.jdbcClient
                .sql("insert into todo (todo, is_complete, created_at) VALUES (?, ?, ?)")
                .params(List.of(todo.todo(), todo.isComplete(), todo.createdAt()))
                .update();
    }

    public void updateTodo(Integer id, Todo todo) {
        this.jdbcClient
                .sql("update todo set todo = ?, is_complete = ?, created_at = ? where id = ?")
                .params(List.of(todo.todo(), todo.isComplete(), todo.createdAt(), id))
                .update();
    }

    public void deleteTodo(Integer id) {
        this.jdbcClient
                .sql("delete from todo where id = ?")
                .params(List.of(id))
                .update();
    }
}
