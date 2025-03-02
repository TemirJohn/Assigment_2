package org.example.service;

import org.example.model.Task;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskHandler {

    private final TaskService taskService;

    @Autowired
    public TaskHandler(@Qualifier("specialtaskservice") TaskService taskService) {
        this.taskService = taskService;
    }

    public void handleTasks() {
        System.out.println("Handling tasks using AlternativeTaskService");

        Task task = taskService.createTask("Task B", "Description B", "IN_PROGRESS");
        System.out.println("Created task: " + task);

        List<Task> tasks = taskService.getAllTasks();
        System.out.println("All tasks: " + tasks);

        taskService.deleteTask(task.getId());
        System.out.println("Deleted task with ID: " + task.getId());

        System.out.println("Tasks after deletion: " + taskService.getAllTasks());
    }
}
