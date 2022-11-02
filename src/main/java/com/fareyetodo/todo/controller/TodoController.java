package com.fareyetodo.todo.controller;

import com.fareyetodo.todo.model.ToDo;
import com.fareyetodo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @CrossOrigin(origins = "http://localhost:3000")
    public class TodoController {

        @Autowired
        private TodoService todoService;

        @GetMapping("/tasks")
        public ResponseEntity gettodos(){
            return new ResponseEntity(todoService.gettodos(), HttpStatus.OK);
        }

        @GetMapping("/tasks/{id}")
        public ResponseEntity gettodo(@PathVariable("id") Integer id){
            return new ResponseEntity<>(this.todoService.getTodo(id), HttpStatus.OK);
        }

        @PostMapping("/tasks")
        public ResponseEntity createTodo(@RequestBody ToDo todo){
            return new ResponseEntity(todoService.addTodo(todo),HttpStatus.CREATED);
        }

        @PutMapping("/tasks")
        public ResponseEntity updateTodo(@RequestBody ToDo todo){
            return new ResponseEntity(todoService.updateTodo(todo),HttpStatus.OK);
        }

        @DeleteMapping("/tasks/{id}")
        public ResponseEntity deleteTodo(@PathVariable("id") Integer id){
            todoService.deleteTodo(id);
            return new ResponseEntity<>("success deleted",HttpStatus.NO_CONTENT);
        }
    }





















//
//    public static HashMap<Integer, ToDo> tasks = new HashMap<Integer, ToDo>();
//    int todoId;
//
//    @GetMapping("/tasks")
//    public HashMap<Integer,ToDo> getTasks()
//    {
//        return tasks;
//    }
//
//    @PostMapping("/tasks")
//        public HashMap<Integer, ToDo> createTask(@RequestBody @Valid ToDo todo1){
//        todo1.setId(todoId);
//        tasks.put(todo1.getId(),todo1);
//        todoId++;
//        return tasks;
//    }
//
//    @PutMapping("/tasks/{id}")
//    public ToDo updateTask(@RequestBody ToDo todo1, @PathVariable("id") int id) throws Exception{
//        if(!tasks.containsKey(id)){
//            throw new Exception("ID does not exist");
//        }
//        todo1.setId(id);
//        tasks.put(id,todo1);
//        return tasks.get(id);
//    }
//
//    @DeleteMapping("tasks/{id}")
//    public void deleteTask(@PathVariable("id") int id) throws Exception{
//        if(!tasks.containsKey(id)){
//            throw new Exception("ID does not exist");
//        }
//        tasks.remove(id);
//    }
//}
//
//
//
//
///*
//
//@RestController
//@RequestMapping("/todo")
//public class ToDoController {
//
//    private final ToDoService todoService;
//
//    @Autowired
//    public ToDoController(ToDoService todoService) {
//        this.todoService = todoService;
//    }
//
//    @GetMapping("/tasks")
//    public List<ToDo> get(){
//        return todoService.todos ;
//    }
//    @PostMapping("/tasks")
//    public List<ToDo> create(@RequestBody @Valid ToDo todo){
//        todoService.todos.add(todo);
//        return todoService.todos;
//    }
//    @PutMapping("/tasks/{id}")
//    public List<ToDo> update(@PathVariable("id") int id, @RequestBody ToDo todo){
//        for(int i=0;i< todoService.todos.size();i++){
//            if(todoService.todos.get(i).getId()==id){
//                todoService.todos.set(i, todo);
//            }
//        }
//        return todoService.todos;
//    }
//
//    @DeleteMapping("/{id}")
//    public List<ToDo> delete(@PathVariable(value = "id") int todoId) {
//        for(int i=0;i< todoService.todos.size();i++){
//            if(todoService.todos.get(i).getId()==todoId){
//                todoService.todos.remove(i);
//            }
//        }
//        return todoService.todos;
//    }
//}
//*/