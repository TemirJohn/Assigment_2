package org.example.repository;
import org.example.model.Task;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TaskRepository {
    private final Map<Long, Task> tasks = new HashMap<>();

    public void saveTask(Task task) {
        tasks.put(task.id, task);
    }

    public Task getTask(Long id) {
        return tasks.get(id);
    }
}
