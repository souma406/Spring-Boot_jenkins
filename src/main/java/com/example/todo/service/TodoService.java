package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@SuppressWarnings("null")
public class TodoService {
    
    private final TodoRepository todoRepository;
    
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    @Transactional(readOnly = true)
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Todo> getTodoById(String id) {
        return todoRepository.findById(id);
    }
    
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }
    
    public Optional<Todo> updateTodo(String id, Todo updatedTodo) {
        return todoRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(updatedTodo.getTitle());
                    existing.setDescription(updatedTodo.getDescription());
                    existing.setCompleted(updatedTodo.isCompleted());
                    return todoRepository.save(existing);
                });
    }
    
    public boolean deleteTodo(String id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todoRepository.delete(todo);
                    return true;
                })
                .orElse(false);
    }
    
    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }
}
