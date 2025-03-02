package org.example.service;

import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Optional;


@Service("defaultTaskService")
@Primary
public class DefaultTaskService implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(String title, String description, String status) {
        return taskRepository.save(new Task(0, title, description, status));
    }


    public void deleteTask(int id) {
        taskRepository.delete(id);
    }
}
