package com.to_do_list.ToDoList.exception;

public class TaskNoFoundException extends RuntimeException{
    public TaskNoFoundException(String message) {
        super(message);
    }
}
