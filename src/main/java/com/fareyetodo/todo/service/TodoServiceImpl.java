package com.fareyetodo.todo.service;

import com.fareyetodo.todo.dao.TodoRep;
import com.fareyetodo.todo.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRep todoRep;
    @Override
    public List<ToDo> gettodos() {
        return todoRep.findAll();
    }

    @Override
    public ToDo getTodo(Integer id) {
        return todoRep.findById(id).orElseThrow(()->new NoSuchElementException("this id= "+id+" is not here"));
    }

    @Override
    public ToDo addTodo(ToDo todo) {
        todoRep.save(todo);
        return todo;
    }

    @Override
    public ToDo updateTodo(ToDo todo) {
        todoRep.findById(todo.getId()).orElseThrow(()->new NoSuchElementException("this id= "+todo.getId()+" is not here"));
        todoRep.save(todo);
        return todo;
    }

    @Override
    public void deleteTodo(Integer id) {
        todoRep.findById(id).orElseThrow(()->new NoSuchElementException("this id= "+id+" is not here"));
        todoRep.deleteById(id);
    }
}