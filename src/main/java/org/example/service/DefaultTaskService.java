package org.example.service;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;


@Service
@Primary
class DefaultTaskService implements TaskService {
    private final TaskRepository repository;

    public DefaultTaskService(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addTask(Long id, String description) {
        repository.saveTask(new Task(id, description));
        System.out.println("DefaultTaskService: Task added.");
    }

    @Override
    public Task fetchTask(Long id) {
        return repository.getTask(id);
    }

    @Override
    public void completeTask(Long id) {
        Task task = repository.getTask(id);
        if (task != null) {
            task.markComplete();
            System.out.println("DefaultTaskService: Task completed.");
        }
    }
}
