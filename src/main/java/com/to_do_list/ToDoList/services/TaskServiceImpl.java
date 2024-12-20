package com.to_do_list.ToDoList.services;

import com.to_do_list.ToDoList.domain.Task;
import com.to_do_list.ToDoList.exception.TaskNoFoundException;
import com.to_do_list.ToDoList.repositories.TaskRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{


    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getbyId(ObjectId id) {
        List<Task> tasks = new ArrayList<>(taskRepository.findAll());
        for (Task t : tasks){
            if (t.getId().equals(id)){
                return t;
            }

        }
        throw new TaskNoFoundException("Task con ID " + id + " no encontrado");
    }

    @Override
    public Task putTask(Task task) {
        List<Task> tasks = new ArrayList<>(taskRepository.findAll());
        for (Task t : tasks){
            if (t.getId().equals(task.getId())){
                t.setTitulo(task.getTitulo());
                t.setDescripcion(task.getDescripcion());
                t.setFechaVencimiento(task.getFechaVencimiento());
                t.setEstado(task.getEstado());
                t.setPrioridad(task.getPrioridad());
                taskRepository.save(t);
                return t;
            }

        }
        throw new TaskNoFoundException("Task con ID: " + task.getId() + " no encontrado");

    }

    @Override
    public String delete(ObjectId id) {
        List<Task> tasks = new ArrayList<>(taskRepository.findAll());
        for (Task t:tasks){
            if (t.getId().equals(id)){
                taskRepository.delete(t);
                return "Tarea con ID: " + t.getId() + " eliminado exitosamente";
            }
        }

        throw new TaskNoFoundException("Task con ID " + id + " no encontrado");
    }

}
