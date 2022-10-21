package com.fareyetodo.todo.service;

import com.fareyetodo.todo.model.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean("item1")
    public Item getUniqueItem(){
        System.out.println("making item1");
        return new Item(123, "item 1");
    }

}
