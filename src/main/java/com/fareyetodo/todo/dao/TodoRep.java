package com.fareyetodo.todo.dao;

import com.fareyetodo.todo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRep extends JpaRepository<ToDo,Integer> {
}