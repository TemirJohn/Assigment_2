package org.example.model;

public class Task {
    public Long id;
    private String description;
    private boolean completed;

    public Task(Long id, String description) {
        this.id = id;
        this.completed = false;
        this.description = description;
    }

    public void markComplete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
