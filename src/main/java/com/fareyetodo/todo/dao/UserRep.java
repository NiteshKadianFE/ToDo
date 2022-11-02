package com.fareyetodo.todo.dao;

import com.fareyetodo.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Integer> {
        User findByUsername(String username);
}