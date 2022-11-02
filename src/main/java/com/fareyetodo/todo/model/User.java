package com.fareyetodo.todo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter @Setter
@Entity
@Table(name = "users")
public class User {
    private String firstName;
    private String lastName;
    private String username;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
//    private boolean enabled;
//    private String avatarUrl;
//    private String githubUserName;
//
//    private String gitAvatar;
//    private Boolean verified, created, modified;
//
    private String password, mySecurePassword;

//    public User()
//    {
//        Password userPassword = new Password("mypassword123");
//        this.password = userPassword.getMySecurePassword();
//        this.verified = Boolean.FALSE;
//        this.mySecurePassword = userPassword.getMySecurePassword();
//    }
//    public void setGithubUserName(String githubUserName) throws JsonProcessingException {
//        this.githubUserName = githubUserName;
//        this.gitAvatar = GitController.getavtar(githubUserName);
//    }
//
//    private Boolean active;
    private String role;

    public User() {

    }

    public User(String firstName, int id) {
        this.firstName = firstName;
        this.id = id;
    }
}
