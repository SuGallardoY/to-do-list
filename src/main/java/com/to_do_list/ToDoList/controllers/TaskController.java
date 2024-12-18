package com.to_do_list.ToDoList.controllers;

import com.to_do_list.ToDoList.domain.Task;
import com.to_do_list.ToDoList.services.TaskService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/toDoList/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    //traer todas las task
    @GetMapping
    public ResponseEntity<List<Task>>  getAll(){
        return ResponseEntity.ok(taskService.getAll());
    }

    //crear task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    //buscar por Id
    @GetMapping("/{id}")
    public ResponseEntity<Task>  findbyID(@PathVariable ObjectId id){
        Task findedTask = taskService.getbyId(id);
        return ResponseEntity.ok(findedTask);
    }

    //modificar task
    @PutMapping
    public ResponseEntity<Task> editeTask(@RequestBody Task task){
        Task editedTask = taskService.putTask(task);
        if (editedTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editedTask);
    }

    //delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable ObjectId id){
        Task findedTask = taskService.getbyId(id);
        if (findedTask != null){
            taskService.delete(id);
        }
        return ResponseEntity.ok().body("Eliminado correctamente");

    }



}
