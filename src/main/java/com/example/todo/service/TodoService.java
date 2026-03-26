package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TodoService {
    
    private final ConcurrentHashMap<String, Todo> todos = new ConcurrentHashMap<>();
    
    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos.values());
    }
    
    public Optional<Todo> getTodoById(String id) {
        return Optional.ofNullable(todos.get(id));
    }
    
    public Todo createTodo(Todo todo) {
        todos.put(todo.getId(), todo);
        return todo;
    }
    
    public Optional<Todo> updateTodo(String id, Todo updatedTodo) {
        return Optional.ofNullable(todos.computeIfPresent(id, (key, existing) -> {
            existing.setTitle(updatedTodo.getTitle());
            existing.setDescription(updatedTodo.getDescription());
            existing.setCompleted(updatedTodo.isCompleted());
            return existing;
        }));
    }
    
    public boolean deleteTodo(String id) {
        return todos.remove(id) != null;
    }
    
    public void deleteAllTodos() {
        todos.clear();
    }
}
