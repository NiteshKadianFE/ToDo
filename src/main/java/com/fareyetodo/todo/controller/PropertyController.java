package com.fareyetodo.todo.controller;

//import com.fareyetodo.todo.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RestController
public class PropertyController {

    @GetMapping("/properties")
    public Properties properties(){
        Properties p = System.getProperties();
        try{
            p.load(new FileReader("/home/nitesh/Downloads/todo/src/main/resources/application.properties"));
        }
        catch (IOException e){
            System.out.println("This is reader exception");
            throw new RuntimeException(e);
        }
        return p;
    }

}
