package com.to_do_list.ToDoList.repositories;

import com.to_do_list.ToDoList.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
}
