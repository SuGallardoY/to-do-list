package com.to_do_list.ToDoList.services;

import com.to_do_list.ToDoList.domain.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {

    //get all usuarios
    public List<User> getAllUsers();

    //traer usuario por id
    public User getById(ObjectId id);

    //crear un nuevo usuario
    public User createUser(User user);

    //editar usuario
    public User editeUser(User user);

    //borrar usuario
    public String deleteUser(ObjectId id);
}
