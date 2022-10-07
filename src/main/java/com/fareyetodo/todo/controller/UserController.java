package com.fareyetodo.todo.controller;

import com.fareyetodo.todo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> users = new ArrayList<>();

    @PostMapping("/user")
    public User createUser(@RequestBody User user)
    {
        users.add(user);
        return user;
    }

    @GetMapping("/user")
    public List<User> getUsers(){
        return users;
    }


}
