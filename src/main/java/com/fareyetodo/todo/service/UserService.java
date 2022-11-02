package com.fareyetodo.todo.service;

import com.fareyetodo.todo.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public User getUser(Integer id);

    public User addUser(User user);

    public User updateUser(User user);

    public void deleteUser(Integer id);

    public User getByUsername(String username);
}