package org.example;

import org.example.service.TaskService;
import org.example.singleton.LazySingleton;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(org.example.config.AppConfig.class);

        TaskService taskService = context.getBean(TaskService.class);
        taskService.addTask(1L, "Finish project");
        System.out.println(taskService.fetchTask(1L));
        taskService.completeTask(1L);
        System.out.println(taskService.fetchTask(1L));

        TaskService specialService = context.getBean("specialTaskService", TaskService.class);
        specialService.addTask(2L, "Prepare report");
        System.out.println(specialService.fetchTask(2L));
        specialService.completeTask(2L);
        System.out.println(specialService.fetchTask(2L));

        context.getBean(LazySingleton.class);

        context.close();
    }
}