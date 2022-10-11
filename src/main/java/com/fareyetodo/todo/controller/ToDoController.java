package com.fareyetodo.todo.controller;

import com.fareyetodo.todo.model.ToDo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class ToDoController {

    public static HashMap<Integer, ToDo> tasks = new HashMap<Integer, ToDo>();
    int todoId;

    @GetMapping("/tasks")
    public HashMap<Integer,ToDo> getTasks()
    {
        return tasks;
    }

    @PostMapping("/tasks")
        public HashMap<Integer, ToDo> createTask(@RequestBody @Valid ToDo todo1){
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




/*

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService todoService;

    @Autowired
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/tasks")
    public List<ToDo> get(){
        return todoService.todos ;
    }
    @PostMapping("/tasks")
    public List<ToDo> create(@RequestBody @Valid ToDo todo){
        todoService.todos.add(todo);
        return todoService.todos;
    }
    @PutMapping("/tasks/{id}")
    public List<ToDo> update(@PathVariable("id") int id, @RequestBody ToDo todo){
        for(int i=0;i< todoService.todos.size();i++){
            if(todoService.todos.get(i).getId()==id){
                todoService.todos.set(i, todo);
            }
        }
        return todoService.todos;
    }

    @DeleteMapping("/{id}")
    public List<ToDo> delete(@PathVariable(value = "id") int todoId) {
        for(int i=0;i< todoService.todos.size();i++){
            if(todoService.todos.get(i).getId()==todoId){
                todoService.todos.remove(i);
            }
        }
        return todoService.todos;
    }
}
*/