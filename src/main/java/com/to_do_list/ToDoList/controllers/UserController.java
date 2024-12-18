package com.to_do_list.ToDoList.controllers;

import com.to_do_list.ToDoList.domain.Task;
import com.to_do_list.ToDoList.domain.User;
import com.to_do_list.ToDoList.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/toDoList/users")
public class UserController {

    @Autowired
    private UserService userService;

    //obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    //crear un usuario
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    //buscar por Id
    @GetMapping("/{id}")
    public ResponseEntity<User>  findbyID(@PathVariable ObjectId id){
        User findedUser = userService.getById(id);
        return ResponseEntity.ok(findedUser);
    }

    //modificar user
    @PutMapping
    public ResponseEntity<User> editeUser(@RequestBody User user){
        User editedUser = userService.editeUser(user);
        if (editedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editedUser);
    }

    //delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ObjectId id){
        User findedUser = userService.getById(id);
        if (findedUser != null){
            userService.deleteUser(findedUser.getId());
        }
        return ResponseEntity.ok().body("Eliminado correctamente");

    }


}
