package org.example.service;

import org.example.model.Task;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    void addTask(Long id, String description);
    Task fetchTask(Long id);
    void completeTask(Long id);
}
