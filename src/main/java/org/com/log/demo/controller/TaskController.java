//package org.com.crnk.demo.controller;
//
//import model.org.com.log.demo.PersonSimple;
//import model.org.com.log.demo.Task;
//import service.org.com.log.demo.PersonSimpleService;
//import service.org.com.log.demo.TaskService;
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
