package com.fareyetodo.todo.service;

import com.fareyetodo.todo.model.ToDo;

import java.util.List;

public interface TodoService {


    public List<ToDo> gettodos();

    public ToDo getTodo(Integer id);

    public ToDo addTodo(ToDo todo);

    public ToDo updateTodo(ToDo todo);

    public void deleteTodo(Integer id);
}
