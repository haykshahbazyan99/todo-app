package com.hayk.todolist.controller;

import com.hayk.todolist.model.ToDoItem;
import com.hayk.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping
    public List<ToDoItem> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ToDoItem getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public ToDoItem createTodo(@RequestBody ToDoItem todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public ToDoItem updateTodo(@PathVariable Long id, @RequestBody ToDoItem updatedTodo) {
        return todoService.updateTodo(id, updatedTodo);
    }


    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }


}
