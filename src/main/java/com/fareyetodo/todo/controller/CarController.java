package com.fareyetodo.todo.controller;

import com.fareyetodo.todo.model.Car;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class CarController {

    @PostMapping("/car")
    public String createCar(@RequestBody @Valid Car car, BindingResult bindingResult)
    {
        bindingResult.hasErrors();
        return car.toString();
    }



}
