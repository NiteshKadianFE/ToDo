package com.fareyetodo.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @Autowired
    private UserDetailsService userDetailsService;

    //    @Autowired
//    private ProviderManager providerManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String welcome() {
        return "Welcome to Todo App";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return "You are authenticated as " + authentication.getName();
    }

    @RequestMapping(value = "/admin/user/{username}", method = RequestMethod.GET)
    public UserDetails getListOfUser(@PathVariable String username){
        return userDetailsService.loadUserByUsername(username);
    }
}