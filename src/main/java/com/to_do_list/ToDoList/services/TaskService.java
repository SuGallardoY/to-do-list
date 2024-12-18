package com.to_do_list.ToDoList.services;

import com.to_do_list.ToDoList.domain.Task;
import com.to_do_list.ToDoList.repositories.TaskRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService{

    //obtener todas las tareas
    public List<Task> getAll();

    //crear un task
    public Task createTask(Task task);

    //traer task por id
    public Task getbyId(ObjectId id);

    //modificar con PUT
    public Task putTask(Task task);

    //delete
    public String delete(ObjectId id);

}
