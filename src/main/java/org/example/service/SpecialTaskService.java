package org.example.service;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("specialtaskservice")
public class SpecialTaskService implements TaskService {
    private final TaskRepository taskRepository;

    public SpecialTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return Collections.emptyList();
    }

    @Override
    public Optional<Task> getTaskById(int id) {
        return Optional.empty();
    }

    public Task createTask(String title, String description, String status) {
        Task task = new Task(0, title, description, status);
        taskRepository.save(task);
        return task; // ✅ Возвращаем сохраненную задачу
    }

    @Override
    public void deleteTask(int id) {
    }
}
