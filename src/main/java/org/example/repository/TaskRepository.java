package org.example.repository;
import org.example.model.Task;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TaskRepository {
    private final Map<Integer, Task> tasks = new HashMap<>();
    private int currentId = 1;

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Optional<Task> findById(int id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public Task save(Task task) {
        task = new Task(currentId++, task.getTitle(), task.getDescription(), task.getStatus());
        tasks.put(task.getId(), task);
        return task;
    }

    public void delete(int id) {
        tasks.remove(id);
    }
}
