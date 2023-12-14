package com.hayk.todolist.repository;

import com.hayk.todolist.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<ToDoItem, Long> {


}
