package com.fareyetodo.todo.controller;

import com.fareyetodo.todo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserControllerTest {

    @Test
    void getUser(){
        UserController controller = new UserController();
        ResponseEntity response = controller.getUser();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
void createUser() {
    UserController controller = new UserController();
    User user = new User();
    user.setFirstName("Nitesh");
    user.setLastName("Kadian");
    user.setEmail("nk@gmail.com");
    user.setRole("USER");
    ResponseEntity response = controller.createUser(user);
    assertEquals(response.getStatusCode(), HttpStatus.OK);
    assertEquals(response.getBody(), user);
}

    @Test
    void putUser(){
        int idToBeUpdated = 0;
        UserController controller = new UserController();

        try{
            User user = new User();
            user.setFirstName("Nits");
            user.setLastName("Kads");
            user.setEmail("nks@gmail.com");
            user.setRole("USER");

            ResponseEntity response = controller.deleteUser(idToBeUpdated);

            assertEquals(response.getStatusCode(), HttpStatus.OK);
            assertEquals(controller.getUserData().containsKey(idToBeUpdated), true);
            assertEquals(controller.getUserData().get(idToBeUpdated),response.getBody());
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"This Id does not exist");
        }
    }


    @Test
    void deleteUser(){
        int idToBeDeleted = 0;
        UserController controller = new UserController();
        if(controller.getUserData().containsKey(idToBeDeleted)){
            try{
                ResponseEntity response = controller.deleteUser(idToBeDeleted);

                assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
                assertEquals(controller.getUserData().containsKey(idToBeDeleted), false);
            } catch (Exception e){
                assertEquals(e.getMessage(),"This Id does not exist");
            }
        }
    }
















//    @Test
//    void createUser() {
//        RestTemplate restTemplate = new RestTemplate();
//        HashMap<Integer, User> user1 = new HashMap<>();
//        user1.get(0).setFirstName("Nitesh");
//        user1.get(0).setEmail("nks@gmail.com");
//        user1.get(0).setLastName("Kadian");
//        user1.get(0).setRole("USER");
//        HashMap<Integer, User> addedUser = restTemplate.postForObject("http://localhost:8081/user", user1, HashMap.class);
//        assertEquals(user1.get(0).getFirstName(), addedUser.get(0).getFirstName());
//    }
//@Test
//void createUser() {
//    RestTemplate restTemplate = new RestTemplate();
//    User user1 = new User();
//    user1.setFirstName("Nitesh");
//    user1.setEmail("nks@gmail.com");
//    user1.setLastName("Kadian");
//    user1.setRole("USER");
//    User addedUser = restTemplate.postForObject("http://localhost:8081/adduser", user1, User.class);
//    assertEquals(user1.getFirstName(), addedUser.getFirstName());
//}

//    @Test
//    void getUser(){
//        RestTemplate restTemplate = new RestTemplate();
////        JSONObject obj = new JSONObject();
////
////        obj.put("firstName","Nitesh");
////        obj.put("email","nk@gmail.com");
////        obj.put("lastName","Kadian");
////        obj.put("role","USER");
////        User user1 = new User();
////        System.out.println("hello");
////        user1.setFirstName("Nitesh");
////        user1.setEmail("nks@gmail.com");
////        user1.setLastName("Kadian");
////        user1.setRole("USER");
////        System.out.println("hello1");
//        HashMap<Integer, User> user1 = new HashMap<Integer, User>();
//        user1.put(new Integer(0), new User());
//        user1.get(0).setFirstName("Nitesh");
//        user1.get(0).setEmail("nks@gmail.com");
//        user1.get(0).setLastName("Kadian");
//        user1.get(0).setRole("USER");
//        HashMap<Integer, User> addedUser = restTemplate.getForObject("http://localhost:8081/user", HashMap.class);
//        assertEquals(user1.get(0).getFirstName(), addedUser.get("0").getFirstName());
//    }

//
//    @Test
//    void putUser(){
//        RestTemplate restTemplate = new RestTemplate();
//        HashMap<Integer, User> user1 = new HashMap<>();
//        user1.get(0).setFirstName("Nitesh");
//        user1.get(0).setEmail("nks@gmail.com");
//        user1.get(0).setLastName("Kadian");
//        user1.get(0).setRole("USER");
//        restTemplate.put("http://localhost:8081/user", HashMap.class);
//        HashMap<Integer, User> addedUser = restTemplate.getForObject("http://localhost:8081/user", HashMap.class);
//        assertEquals(user1.get(0).getFirstName(), addedUser.get(0).getFirstName());
//    }
//
//
//
//    @Test
//    void deleteUser(){
//        RestTemplate restTemplate = new RestTemplate();
//        HashMap<Integer, User> user1 = new HashMap<>();
//        user1.get(0).setFirstName("Nitesh");
//        user1.get(0).setEmail("nks@gmail.com");
//        user1.get(0).setLastName("Kadian");
//        user1.get(0).setRole("USER");
//        restTemplate.delete("http://localhost:8081/user", HashMap.class);
//    }

}