//package org.com.crnk.demo.controller;
//
//import org.com.crnk.demo.model.PersonSimple;
//import org.com.crnk.demo.model.Task;
//import org.com.crnk.demo.service.PersonSimpleService;
//import org.com.crnk.demo.service.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/task")
//public class TaskController {
//
//    @Autowired
//    private TaskService taskService;
//
//    @GetMapping
//    public List<Task> getAllTasks() {
//        return taskService.getAllTasks();
//    }
//
//    @PostMapping
//    public Task saveTask(@RequestBody Task task) {
//        return taskService.saveTask(task);
//    }
//}
