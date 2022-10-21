package com.fareyetodo.todo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddServiceTest {


    @Test
    void twoPlusTwoIsFour(){
        AddService addService = new AddService();
        assertEquals(4, addService.add(2,2));
    }

    @Test
    void twoPlusTenIsTwelve(){
        AddService addService = new AddService();
        assertEquals(12, addService.add(10,2));
    }

    @Test
    void threePlusTenIsThirteen(){
        AddService addService = new AddService();
        assertEquals(13, addService.add(10,3));
    }

}