package com.fareyetodo.todo.model;

import com.fareyetodo.todo.controller.GitController;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class User {
    private String firstName;
    private String lastName;
    private int id;
    private String email;
    private String avatarUrl;
    private String githubUserName;

    private String gitAvatar;
    private Boolean verified, created, modified;

    private String password, mySecurePassword;

    public User()
    {
        Password userPassword = new Password("mypassword123");
        this.password = userPassword.getMySecurePassword();
        this.verified = Boolean.FALSE;
        this.mySecurePassword = userPassword.getMySecurePassword();
    }
    public void setGithubUserName(String githubUserName) throws JsonProcessingException {
        this.githubUserName = githubUserName;
        this.gitAvatar = GitController.getavtar(githubUserName);
    }

    private Boolean active;
    private String role;



}
