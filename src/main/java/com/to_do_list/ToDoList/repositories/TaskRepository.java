package com.to_do_list.ToDoList.repositories;

import com.to_do_list.ToDoList.domain.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaskRepository extends MongoRepository<Task, ObjectId> {

}
