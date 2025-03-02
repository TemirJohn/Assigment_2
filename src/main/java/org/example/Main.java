package org.example;

import org.example.config.AppConfig;
import org.example.service.TaskHandler;
import org.example.service.TaskService;
import org.example.singleton.LazySingleton;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TaskService taskService = context.getBean("specialtaskservice" ,TaskService.class);

        TaskHandler taskHandler = context.getBean(TaskHandler.class);
        taskHandler.handleTasks();

        taskService.createTask("First Task", "This is the first task", "NEW");
        taskService.createTask("Second Task", "This is the second task", "IN_PROGRESS");
        taskService.createTask("Third Task", "This is the third task", "DONE");

        System.out.println("All Tasks: " + taskService.getAllTasks());

        System.out.println("Task with ID 2: " + taskService.getTaskById(2));

        taskService.deleteTask(1);
        System.out.println("All Tasks after deletion: " + taskService.getAllTasks());

        System.out.println("Requesting LazySingleton bean...");
        LazySingleton lazySingleton = context.getBean(LazySingleton.class);
        System.out.println("LazySingleton bean received: " + lazySingleton);


        context.close();
    }
}