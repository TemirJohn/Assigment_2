package org.example.service;

import org.example.model.Task;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(int id);
    Task createTask(String title, String description, String status);
    void deleteTask(int id);
}
