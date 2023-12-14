package com.hayk.todolist.service;

import com.hayk.todolist.model.ToDoItem;
import com.hayk.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    public List<ToDoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    public ToDoItem getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public ToDoItem createTodo(ToDoItem todo) {
        return todoRepository.save(todo);
    }


    public ToDoItem updateTodo(Long id, ToDoItem updatedTodo) {
        ToDoItem todo = todoRepository.findById(id).orElse(null);

        if (todo != null) {
            todo.setTitle(updatedTodo.getTitle());
            todo.setDescription(updatedTodo.getDescription());
            return todoRepository.save(todo);
        }

        return null;
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

}
