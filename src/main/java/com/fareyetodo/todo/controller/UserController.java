package com.fareyetodo.todo.controller;

import com.fareyetodo.todo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {
    public static HashMap<Integer, User> userMap = new HashMap<Integer, User>();
    int userId;

    HashMap<Integer, User> getUserData(){
        return userMap;
    }


    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody User user) {
        user.setId(userId);
//        user.setAvatarUrl(DataFromApi.call(user.getGithubUserName()));
        userMap.put(user.getId(), user);
        userId++;

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
//    @PostMapping("/user")
//    public HashMap<Integer, User> createUser(@RequestBody User user) {
//        user.setId(userId);
////        user.setAvatarUrl(DataFromApi.call(user.getGithubUserName()));
//        userMap.put(user.getId(), user);
//        userId++;
//
//        return userMap;
//    }



    @PostMapping("/adduser")
    public User createUsers(@RequestBody User user) {
        user.setId(userId);
//        user.setAvatarUrl(DataFromApi.call(user.getGithubUserName()));
        userMap.put(user.getId(), user);
        userId++;
        return userMap.get(userId);
    }
    @GetMapping("/user")
    public ResponseEntity getUser() {
        return new ResponseEntity<>(userMap, HttpStatus.OK);
    }
//
//    @GetMapping("/user")
//    public HashMap<Integer, User> getUser() {
//        return userMap;
//    }

    @PutMapping("/user/{id}")
    public ResponseEntity updateUser(@RequestBody User user, @PathVariable("id") int id) throws Exception {
        if (!userMap.containsKey(id)) {
            throw new Exception("ID does not exist");
        }
        user.setId(id);
        userMap.put(id, user);
        return new ResponseEntity(userMap.get(id), HttpStatus.OK);
    }

//    @PutMapping("/user/{id}")
//    public User updateUser(@RequestBody User user, @PathVariable("id") int id) throws Exception {
//        if (!userMap.containsKey(id)) {
//            throw new Exception("ID does not exist");
//        }
//        user.setId(id);
//        userMap.put(id, user);
//        return userMap.get(id);
//    }

    @DeleteMapping("user/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id) throws Exception{
        if(!userMap.containsKey(id))
            throw new Exception("This Id does not exist");
        userMap.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @DeleteMapping("user/{id}")
//    public void deleteUser(@PathVariable("id") int id) throws Exception{
//        if(!userMap.containsKey(id))
//            throw new Exception("This Id does not exist");
//        userMap.remove(id);
//    }
}






