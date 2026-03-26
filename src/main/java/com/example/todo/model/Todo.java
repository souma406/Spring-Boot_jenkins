package com.example.todo.model;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

public class Todo {
    private String id;
    
    @NotBlank(message = "Le titre est obligatoire")
    private String title;
    
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    
    public Todo() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.completed = false;
    }
    
    public Todo(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
