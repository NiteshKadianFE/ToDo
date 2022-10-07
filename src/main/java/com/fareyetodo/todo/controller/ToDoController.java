package com.fareyetodo.todo.controller;

import com.fareyetodo.todo.model.ToDo;
import com.fareyetodo.todo.model.User;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ToDoController {

    HashMap<Integer, ToDo> tasks = new HashMap<Integer, ToDo>();
    int todoId;

    @GetMapping("/tasks")
    public HashMap<Integer,ToDo> getTasks()
    {
        return tasks;
    }

    @PostMapping("/tasks")
        public HashMap<Integer, ToDo> createTask(@RequestBody ToDo todo1){
        todo1.setId(todoId);
        tasks.put(todo1.getId(),todo1);
        todoId++;
        return tasks;
    }

    @PutMapping("/tasks/{id}")
    public ToDo updateTask(@RequestBody ToDo todo1, @PathVariable("id") int id) throws Exception{
        if(!tasks.containsKey(id)){
            throw new Exception("ID does not exist");
        }
        todo1.setId(id);
        tasks.put(id,todo1);
        return tasks.get(id);
    }

    @DeleteMapping("tasks/{id}")
    public void deleteTask(@PathVariable("id") int id) throws Exception{
        if(!tasks.containsKey(id)){
            throw new Exception("ID does not exist");
        }
        tasks.remove(id);
    }
}
