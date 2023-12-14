package com.hayk.todolist.service;

import com.hayk.todolist.model.ToDoItem;
import com.hayk.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
public class TodoServiceTest {

    @Test
    public void testCreateTodo() {

        TodoRepository todoRepository = mock(TodoRepository.class);
        TodoService todoService = new TodoService(todoRepository);

        ToDoItem todo = new ToDoItem();
        todo.setTitle("Test Title");
        todo.setDescription("Test Description");

        when(todoRepository.save(any(ToDoItem.class))).thenReturn(todo);

        ToDoItem createdTodo = todoService.createTodo(todo);

        assertNotNull(createdTodo);
        assertEquals("Test Title", createdTodo.getTitle());
        assertEquals("Test Description", createdTodo.getDescription());

        verify(todoRepository, times(1)).save(any(ToDoItem.class));
    }

}
