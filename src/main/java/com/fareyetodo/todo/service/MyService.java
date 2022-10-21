package com.fareyetodo.todo.service;

import com.fareyetodo.todo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    private Item item1;

    public void printItem(){
        System.out.println(item1.toString());
    }
}
