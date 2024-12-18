package com.to_do_list.ToDoList.services;

import com.to_do_list.ToDoList.domain.Task;
import com.to_do_list.ToDoList.domain.User;
import com.to_do_list.ToDoList.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(ObjectId id) {
        List<User> tasks = new ArrayList<>(userRepository.findAll());
        for (User u : tasks){
            if (u.getId().equals(id)){
                return u;
            }
        }
        return null;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editeUser(User user) {
        List<User> users = new ArrayList<>(userRepository.findAll());
        for (User u : users){
            if (u.getId().equals(user.getId())){
                u.setNombre(user.getNombre());
                u.setApellido(user.getApellido());
                u.setUsuario(user.getUsuario());
                u.setPassword(user.getPassword());
                userRepository.save(u);
                return u;
            }
        }
        return null;
    }

    @Override
    public String deleteUser(ObjectId id) {
        List<User> users = new ArrayList<>(userRepository.findAll());
        for (User u : users)
            if (u.getId().equals(id)) {
                userRepository.delete(u);
                return "Usuario con ID: " + u.getId() + " eliminado exitosamente";
            }
        return "No se ha podido encontrar";
    }
}
