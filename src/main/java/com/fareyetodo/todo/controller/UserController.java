package com.fareyetodo.todo.controller;

import com.fareyetodo.todo.model.User;
import com.fareyetodo.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity getUsers(){
        return new ResponseEntity<>(this.userService.getUsers(),HttpStatus.OK);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity getUser(@PathVariable("id") Integer id){

        return new ResponseEntity<>(this.userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user){
        return new ResponseEntity(this.userService.addUser(user),HttpStatus.CREATED);
    }

//    @PutMapping("/users/{id}")
//    public ResponseEntity updateUser(@PathVariable("id") int id,@RequestBody User user) throws  Exception{
//        if(!users.containsKey(id)) throw new Exception("This key is not in the System");
//        user.setUserId(id);
//        users.put(id,user);
//        return new ResponseEntity(user,HttpStatus.OK);
//    }

    @PutMapping("/users")
    public ResponseEntity updateUser(@RequestBody User user){

        return new ResponseEntity(this.userService.updateUser(user),HttpStatus.OK);

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id){

        userService.deleteUser(id);
        return new ResponseEntity<>("Success Deleted User", HttpStatus.NO_CONTENT);
    }
}



















//    public static HashMap<Integer, User> userMap = new HashMap<Integer, User>();
//    int userId;
//
//    HashMap<Integer, User> getUserData(){
//        return userMap;
//    }
//
//
//    @PostMapping("/users")
//    public ResponseEntity createUser(@RequestBody User user) {
//        user.setId(userId);
////        user.setAvatarUrl(DataFromApi.call(user.getGithubUserName()));
//        userMap.put(user.getId(), user);
//        userId++;
//
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
////    @PostMapping("/user")
////    public HashMap<Integer, User> createUser(@RequestBody User user) {
////        user.setId(userId);
//////        user.setAvatarUrl(DataFromApi.call(user.getGithubUserName()));
////        userMap.put(user.getId(), user);
////        userId++;
////
////        return userMap;
////    }
//
//
//
////    @PostMapping("/adduser")
////    public User createUsers(@RequestBody User user) {
////        user.setId(userId);
//////        user.setAvatarUrl(DataFromApi.call(user.getGithubUserName()));
////        userMap.put(user.getId(), user);
////        userId++;
////        return userMap.get(userId);
////    }
////    @GetMapping("/user")
////    public ResponseEntity getUser() {
////        return new ResponseEntity<>(userMap, HttpStatus.OK);
////    }
////
//    @GetMapping("/users")
//    public HashMap<Integer, User> getUser() {
//        return userMap;
//    }
//
//    @PutMapping("/user/{id}")
//    public ResponseEntity updateUser(@RequestBody User user, @PathVariable("id") int id) throws Exception {
//        if (!userMap.containsKey(id)) {
//            throw new Exception("ID does not exist");
//        }
//        user.setId(id);
//        userMap.put(id, user);
//        return new ResponseEntity(userMap.get(id), HttpStatus.OK);
//    }
//
////    @PutMapping("/user/{id}")
////    public User updateUser(@RequestBody User user, @PathVariable("id") int id) throws Exception {
////        if (!userMap.containsKey(id)) {
////            throw new Exception("ID does not exist");
////        }
////        user.setId(id);
////        userMap.put(id, user);
////        return userMap.get(id);
////    }
//
//    @DeleteMapping("user/{id}")
//    public ResponseEntity deleteUser(@PathVariable("id") int id) throws Exception{
//        if(!userMap.containsKey(id))
//            throw new Exception("This Id does not exist");
//        userMap.remove(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
////    @DeleteMapping("user/{id}")
////    public void deleteUser(@PathVariable("id") int id) throws Exception{
////        if(!userMap.containsKey(id))
////            throw new Exception("This Id does not exist");
////        userMap.remove(id);
////    }







