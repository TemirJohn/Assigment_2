package org.example.service;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Service;



@Service
class SpecialTaskService implements TaskService {
    private final TaskRepository repository;

    public SpecialTaskService(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addTask(Long id, String description) {
        repository.saveTask(new Task(id, "[Special] " + description));
        System.out.println("SpecialTaskService: Special task added.");
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
            System.out.println("SpecialTaskService: Special task completed.");
        }
    }
}
