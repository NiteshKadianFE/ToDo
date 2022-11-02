package com.fareyetodo.todo.service;

import com.fareyetodo.todo.model.User;
import com.fareyetodo.todo.dao.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRep userRep;
    @Override
    public List<User> getUsers() {
        return userRep.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userRep.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        userRep.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userRep.findById(user.getId()).orElseThrow(()-> new NoSuchElementException("This ID = "+user.getId()+" is not here"));
        userRep.save(user);
        return  user;
    }

    @Override
    public void deleteUser(Integer id) {
        userRep.findById(id).get();
        userRep.deleteById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRep.findByUsername(username);
    }
}