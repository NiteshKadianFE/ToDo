package com.fareyetodo.todo.controller;

import com.fareyetodo.todo.model.User;
import com.fareyetodo.todo.util.DataFromApi;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {
    HashMap<Integer, User> userMap = new HashMap<Integer, User>();
    int userId;


    @PostMapping("/user")
    public HashMap<Integer, User> createUser(@RequestBody User user) {
        user.setId(userId);
        user.setAvatarUrl(DataFromApi.call(user.getGithubUserName()));
        userMap.put(user.getId(), user);
        userId++;
        return userMap;
    }

    @GetMapping("/user")
    public HashMap<Integer, User> getUser() {
        return userMap;
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") int id) throws Exception {
        if (!userMap.containsKey(id)) {
            throw new Exception("ID does not exist");
        }
        user.setId(id);
        userMap.put(id, user);
        return userMap.get(id);
    }

    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable("id") int id) throws Exception{
        if(!userMap.containsKey(id))
            throw new Exception("This Id does not exist");
        userMap.remove(id);
    }

}






